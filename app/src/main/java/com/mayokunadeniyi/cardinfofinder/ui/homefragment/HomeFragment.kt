package com.mayokunadeniyi.cardinfofinder.ui.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mayokunadeniyi.cardinfofinder.R
import com.mayokunadeniyi.cardinfofinder.databinding.HomeFragmentBinding

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

class HomeFragment : Fragment(){
    private lateinit var binding : HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ocrCard.setOnClickListener {

        }
        binding.keyboardCard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_inputFragment)
        }
    }
}