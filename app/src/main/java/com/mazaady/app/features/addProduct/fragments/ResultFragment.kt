package com.mazaady.app.features.addProduct.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mazaady.app.R
import com.mazaady.app.databinding.FragmentResultBinding
import com.mazaady.app.features.addProduct.adapters.PopupListAdapter
import com.mazaady.app.features.addProduct.adapters.ResultAdapter


class ResultFragment : BottomSheetDialogFragment() {

    private val TAG = "ResultFragment"
    private lateinit var binding: FragmentResultBinding
    private val args: ResultFragmentArgs by navArgs()

  
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        dialog?.setOnShowListener {
            val d: BottomSheetDialog = dialog as BottomSheetDialog
            val bottomSheetInternal: View = d.findViewById(com.google.android.material.R.id.design_bottom_sheet)!!
            BottomSheetBehavior.from(bottomSheetInternal).setState(BottomSheetBehavior.STATE_EXPANDED)
        }

        binding.apply {
           /* args.data.let {
                tvMainCategory.text=it.mainCategory?.name
                tvSubCategory.text=it.mainCategory?.subCategories?.get(0)?.name
                it.properties?.forEach {
                    it?.let {

                        Log.d(TAG, "onCreateView: ${it?.info?.name}: ${it?.value}")
                        it?.options?.forEach { op->
                            Log.d(TAG, "onCreateView: ${op?.info?.name}: ${op.value}")
                            op.options?.forEach { lastOP ->
                                Log.d(TAG, "onCreateView: ${lastOP?.info?.name}: ${lastOP.value}")
                            }
                        }




                    }
                }

            }*/
            var resultAdapter = ResultAdapter()
            resultAdapter.setItemsList(args.data.properties as ArrayList)
            rvSelectedProperties.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            rvSelectedProperties.adapter = resultAdapter
        }
        return binding.root
    }




  
}