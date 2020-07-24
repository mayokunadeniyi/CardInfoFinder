package com.mayokunadeniyi.cardinfofinder.ui.ocrfragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.text.FirebaseVisionText
import com.mayokunadeniyi.cardinfofinder.R
import com.mayokunadeniyi.cardinfofinder.databinding.OcrFragmentBinding
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import timber.log.Timber
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

class OcrFragment : Fragment() {

    private lateinit var binding: OcrFragmentBinding
    private lateinit var currentPhotoPath: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigateUp()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OcrFragmentBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when {
            allPermissionsGranted() -> {
                startCamera()
                binding.cardImageView.setOnClickListener {
                    startCamera()
                }
            }
            shouldShowRequestPermissionRationale() -> {
                androidx.appcompat.app.AlertDialog.Builder(requireContext())
                    .setTitle("App Permissions")
                    .setMessage("This application requires access to your camera and storage to function!")
                    .setNegativeButton(
                        "No"
                    ) { _, _ -> findNavController().navigate(R.id.action_ocrFragment_to_homeFragment) }
                    .setPositiveButton(
                        "Ask me"
                    ) { _, _ ->
                        requestPermissions(REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
                    }
                    .show()
            }
            else -> {
                requestPermissions(REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
            }
        }

        binding.searchButton.setOnClickListener {
            if (binding.scanResultText.text.isNullOrBlank()){
                val shake = AnimationUtils.loadAnimation(requireContext(), R.anim.shake)
                binding.scanResultText.startAnimation(shake)
            }else{
                val text = binding.scanResultText.text?.toString()
                if (text != null){
                    val trimmedString = text.replace("\\s".toRegex(),"")
                    try {
                        val number = trimmedString.toInt()
                        val action = OcrFragmentDirections.actionOcrFragmentToResultFragment(number)
                        findNavController().navigate(action)
                    }catch (exception: Throwable){
                        val shake = AnimationUtils.loadAnimation(requireContext(), R.anim.shake)
                        binding.scanResultText.startAnimation(shake)
                        Snackbar.make(requireView(),"Ensure correct card number format!",Snackbar.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }

    private fun startCamera() {
        binding.scanResultText.visibility = View.GONE
        binding.searchButton.visibility = View.GONE
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(requireActivity().packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    Timber.e(ex)
                    null
                }

                photoFile?.also {
                    val photoUri: Uri = FileProvider.getUriForFile(
                        requireContext(),
                        "com.mayokunadeniyi.cardinfofinder",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                    startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera()
            } else {
                showThatLayout()
            }
        }
    }

    private fun showThatLayout() {
        findNavController().navigate(R.id.action_ocrFragment_to_homeFragment)
        Snackbar.make(requireView(),"Permissions Denied!",Snackbar.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val bitmap = BitmapFactory.decodeFile(currentPhotoPath)
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && bitmap != null) {
                    val f = File(currentPhotoPath)
                    val uri = Uri.fromFile(f)
                    CropImage.activity(uri)
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(requireContext(), this)
                } else if (bitmap == null) {
                    findNavController().navigate(R.id.action_ocrFragment_to_homeFragment)
                }
            }
            CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE -> {
                val result = CropImage.getActivityResult(data)
                if (resultCode == Activity.RESULT_OK) {
                    val resultUri = result.uri
                    Glide.with(this)
                        .load(resultUri)
                        .into(binding.cardImageView)
                    analyzeImage(resultUri)
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    val error = result.error
                    Timber.e(error)
                    Toast.makeText(requireContext(), "Oops! an error occurred", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    }

    private fun analyzeImage(resultUri: Uri) {
        binding.scanButton.visibility = View.VISIBLE
        binding.scanButton.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            val bitmap =
                MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, resultUri)
            val image = FirebaseVisionImage.fromBitmap(bitmap)
            val firebaseVisionTextDetector = FirebaseVision.getInstance().onDeviceTextRecognizer

            firebaseVisionTextDetector.processImage(image)
                .addOnSuccessListener { result ->
                    binding.progressBar.visibility = View.GONE
                    binding.scanButton.visibility = View.GONE
                    processResultText(result)
                }.addOnFailureListener {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Sorry, something went wrong!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

        }
    }

    private fun processResultText(result: FirebaseVisionText) {
        if (result.textBlocks.size == 0){
            Snackbar.make(requireView(),"No Text Found, tap image to retry",Snackbar.LENGTH_LONG).show()
            return
        }

        for (block in result.textBlocks){
            binding.scanResultText.visibility = View.VISIBLE
            binding.searchButton.visibility = View.VISIBLE
            binding.scanResultText.setText(result.textBlocks[2].text)
        }
    }


    private fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir = this.requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            imageFileName,
            ".jpg",
            storageDir
        )
        currentPhotoPath = image.absolutePath
        return image
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(requireContext(), it) == PackageManager.PERMISSION_GRANTED
    }

    private fun shouldShowRequestPermissionRationale() = REQUIRED_PERMISSIONS.all {
        shouldShowRequestPermissionRationale(it)
    }

    companion object {
        private val REQUIRED_PERMISSIONS =
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        private const val CAMERA_REQUEST_CODE = 101
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
}