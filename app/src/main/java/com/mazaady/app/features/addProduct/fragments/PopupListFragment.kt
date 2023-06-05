package com.mazaady.app.features.addProduct.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mazaady.app.databinding.FragmentPopuplistBinding
import com.mazaady.app.features.addProduct.adapters.PopupListAdapter
import com.mazaady.app.features.addProduct.viewmodels.AddProductViewModel
import com.mazaady.app.util.enums.OperationTypes
import com.mazaady.domain.addProduct.models.*
import com.mazaady.domain.addProduct.responses.CategoriesResponse
import com.mazaady.domain.addProduct.models.Child
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class PopupListFragment : BottomSheetDialogFragment() {

    private val TAG = "PopupListFragment"
    private lateinit var binding: FragmentPopuplistBinding
    private val args: PopupListFragmentArgs by navArgs()

    private val addProductViewModel by sharedViewModel<AddProductViewModel>()
    private lateinit var tempList: ArrayList<Any>
    private lateinit var actualList: ArrayList<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set the window no floating style
        setStyle(DialogFragment.STYLE_NORMAL, com.mazaady.resources.R.style.BottomSheetDialogThemeNoFloating)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPopuplistBinding.inflate(inflater, container, false)

        loadData()
        events()
        return binding.root
    }

    private fun loadData() {

        tempList = ArrayList()
        actualList = ArrayList()

        binding.apply {
            when (args.operationType) {

                OperationTypes.DisplayMainCategory -> {

                    addProductViewModel.categoriesResponseLive.observe(
                        viewLifecycleOwner,
                        Observer {
                            var rs = it?.data as CategoriesResponse
                            tempList.addAll(rs.categories)
                            actualList.addAll(rs.categories)
                            recycleSetup<MainCategory>(tempList as ArrayList<MainCategory>)
                        })


                }
                OperationTypes.DisplaySubCategory -> {

                    addProductViewModel.categoriesResponseLive.observe(
                        viewLifecycleOwner,
                        Observer {

                            var rs = it?.data as CategoriesResponse
                            var selectedChild = ArrayList<SubCategory>()
                            rs.categories.forEach {

                                if (it.id == args.parentID) {
                                    selectedChild = it.subCategories
                                }
                            }
                            ///////////////////////////////////////////////

                            tempList.addAll(selectedChild)
                            actualList.addAll(selectedChild)
                            recycleSetup<SubCategory>(tempList as ArrayList<SubCategory>)
                        })


                }
                OperationTypes.DisplayPropertyOptions -> {


                    addProductViewModel.propertiesResponseLive.observe(
                        viewLifecycleOwner,
                        Observer {


                            var rs = it?.data as ArrayList<Property>
                            rs.forEach {
                                if (it.id == args.parentID) {

                                    var selectedChild = it.options
                                    ///////////////////////////////////////////////

                                    tempList.addAll(selectedChild)
                                    actualList.addAll(selectedChild)
                                    recycleSetup<Option>(tempList as ArrayList<Option>)
                                }
                            }


                        })

                }
                OperationTypes.DisplayOptionOptions -> {


                    addProductViewModel.optionChildrenResponseLive.observe(
                        viewLifecycleOwner,
                        Observer {

                            var rs = it?.data as ArrayList<Child>

                            rs.forEach {
                                if (it.id == args.parentID) {
                                    var other=it.options.find { i->i.id==-100 }
                                    if(other==null){
                                        it.options.add(Option(id=-100,getString(com.mazaady.resources.R.string.other),parent=args.parentID))
                                    }

                                    var selectedChild = it.options
                                    ///////////////////////////////////////////////

                                    tempList.addAll(selectedChild)
                                    actualList.addAll(selectedChild)
                                    recycleSetup<Option>(tempList as ArrayList<Option>)
                                }
                            }


                        })

                }
                OperationTypes.DisplaySubOptionOptions -> {


                    addProductViewModel.childOptionsResponseLive.observe(
                        viewLifecycleOwner,
                        Observer {

                            var rs = it?.data as ArrayList<Child>

                            rs.forEach {
                                if (it.id == args.parentID) {
                                    var other=it.options.find { i->i.id==-100 }
                                    if(other==null){
                                        it.options.add(Option(id=-100,getString(com.mazaady.resources.R.string.other),parent=args.parentID))
                                    }

                                    var selectedChild = it.options
                                    ///////////////////////////////////////////////

                                    tempList.addAll(selectedChild)
                                    actualList.addAll(selectedChild)
                                    recycleSetup<Option>(tempList as ArrayList<Option>)
                                }
                            }


                        })

                }
                else -> {}
            }
        }

    }

    private fun events() {

        binding.apply {

          etCriteria.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    filter(s)

                }

                override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(s: Editable?) {

                }
            })


        }
    }

    private  fun <T> recycleSetup(list:ArrayList<T>){

        binding.apply {
            var optionsAdapter = PopupListAdapter<T>(this@PopupListFragment, args.onSelectedEvent)
            optionsAdapter.setItemsList(list)
            rvResult.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            rvResult.adapter = optionsAdapter
        }

    }


    private fun filter(s:CharSequence?){

        binding.apply {

            if (s?.length!! >0) {

                tempList.clear()
                var searchText=s.toString().trim()

                when (args.operationType) {

                    OperationTypes.DisplayMainCategory -> {

                        (actualList as ArrayList<MainCategory>).forEach {

                            if(it.name?.contains(searchText,ignoreCase = true) == true){
                                tempList.add(it)
                            }
                        }


                    }
                    OperationTypes.DisplaySubCategory -> {

                        (actualList as ArrayList<SubCategory>).forEach {

                            if(it.name?.contains(searchText,ignoreCase = true) == true){
                                tempList.add(it)
                            }
                        }

                    }
                    OperationTypes.DisplayPropertyOptions -> {

                        (actualList as ArrayList<Option>).forEach {

                            if(it.name?.contains(searchText,ignoreCase = true) == true){
                                tempList.add(it)
                            }
                        }

                    }
                    OperationTypes.DisplayOptionOptions -> {
                        (actualList as ArrayList<Option>).forEach {

                            if(it.name?.contains(searchText,ignoreCase = true) == true){
                                tempList.add(it)
                            }
                        }

                    }
                    else -> {}
                }


                rvResult.adapter?.notifyDataSetChanged()


            }else{
                tempList.clear()
                tempList.addAll(actualList)
                rvResult.adapter?.notifyDataSetChanged()


            }
        }


    }


}

