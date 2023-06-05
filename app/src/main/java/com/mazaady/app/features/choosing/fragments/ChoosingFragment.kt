package com.mazaady.app.features.choosing.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mazaady.app.R
import com.mazaady.app.databinding.FragmentChoosingBinding
import com.mazaady.app.databinding.FragmentHomeBinding


class ChoosingFragment : Fragment() {

    private  val TAG = "ChoosingFragment"
    private lateinit var binding: FragmentChoosingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentChoosingBinding.inflate(inflater)
        events()
        return binding.root
    }

    private fun events() {
       binding.apply {
           btnOpenAddProduct.setOnClickListener {
               findNavController().navigate(R.id.action_choosingFragment_to_homeFragment)
           }
           btnOpenDetails.setOnClickListener {
               findNavController().navigate(R.id.action_choosingFragment_to_detailsFragment)
           }
       }
    }


}