package com.mayokunadeniyi.cardinfofinder.ui.resultfragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.mayokunadeniyi.cardinfofinder.MainActivity
import com.mayokunadeniyi.cardinfofinder.databinding.ResultFragmentBinding
import com.mayokunadeniyi.cardinfofinder.ui.resultfragment.presentation.ResultFragmentViewModel
import com.mayokunadeniyi.cardinfofinder.utils.showIf
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Mayokun Adeniyi on 24/07/2020.
 */

class ResultFragment : Fragment() {

    private val viewModel: ResultFragmentViewModel by viewModel()

    private lateinit var binding: ResultFragmentBinding

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
        binding = ResultFragmentBinding.inflate(layoutInflater)
        val resultFragmentArgs by navArgs<ResultFragmentArgs>()
        val cardNumber = resultFragmentArgs.cardNumber
        binding.cardNumber = cardNumber
        viewModel.getLocalCardInfo(cardNumber)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabClose.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }
        binding.coordLayout.visibility = View.GONE
        binding.errorText.visibility = View.GONE

        viewModel.cardInfo.observe(viewLifecycleOwner, Observer { cardInfo ->
            if (cardInfo != null) {
                binding.cardInfo = cardInfo
                binding.coordLayout.visibility = View.VISIBLE
            }
        })

        viewModel.dataFetchState.observe(viewLifecycleOwner, Observer { state ->
           if (!state){
               binding.coordLayout.visibility = View.VISIBLE
               binding.errorText.visibility = View.VISIBLE
               Snackbar.make(requireView(),"Oops! An error occured, check your connection and retry!",Snackbar.LENGTH_LONG).show()
           }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { state ->
            binding.progressBar.showIf { state }
        })
    }
}