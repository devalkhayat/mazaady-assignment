package com.mazaady.app.features.addProduct.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.FragmentHomeBinding
import com.mazaady.app.features.addProduct.adapters.FieldsAdapter
import com.mazaady.app.features.addProduct.viewmodels.AddProductViewModel
import com.mazaady.app.util.enums.OperationTypes
import com.mazaady.app.util.eventListners.RecycleViewEventListener
import com.mazaady.app.util.models.SelectedData
import com.mazaady.app.util.models.SelectedOption
import com.mazaady.app.util.models.SelectedProperty
import com.mazaady.domain.addProduct.models.MainCategory
import com.mazaady.domain.addProduct.models.SubCategory
import com.mazaady.domain.addProduct.models.Option
import com.mazaady.domain.addProduct.models.Property
import com.mazaady.domain.addProduct.models.Child
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {

    private  val TAG = "HomeFragment"
    private lateinit var binding:FragmentHomeBinding
    private  val addProductViewModel by sharedViewModel<AddProductViewModel>()
    private lateinit  var selectedData:SelectedData
    private lateinit var _rvOptions:RecyclerView
    private lateinit var _rvSubOptions:RecyclerView
    private lateinit var onPropertyClickListener:RecycleViewEventListener
    private lateinit var onOptionClickListener:RecycleViewEventListener
    private lateinit var onSubOptionClickListener:RecycleViewEventListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        init()
        observers()
        events()
        return binding.root
    }

    private fun init(){
        addProductViewModel.getAllCategories()
    }
    private fun observers(){

        addProductViewModel.propertiesResponseLive.observe(viewLifecycleOwner, Observer {

            if (it?.status == true) {
                showProperties(it?.data as ArrayList<Property>)
            }
        })
        addProductViewModel.optionChildrenResponseLive.observe(viewLifecycleOwner, Observer {

        if (it?.status == true) {
            if(_rvOptions!=null)
            showOptions(it?.data as ArrayList<Child>)
        }


    })
        addProductViewModel.childOptionsResponseLive.observe(viewLifecycleOwner, Observer {

            if (it?.status == true) {
                if(_rvSubOptions!=null)
                    showSubOptions(it?.data as ArrayList<Child>)
            }

        })

    }
    private fun showProperties(items:ArrayList<Property>){
        binding.apply {
            var optionsAdapter= FieldsAdapter<Property>(onPropertyClickListener)
            optionsAdapter.setItemsList(items)
            rvProperties.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            rvProperties.adapter=optionsAdapter
            rvProperties.isNestedScrollingEnabled=false
        }
    }
    private fun showOptions(items:ArrayList<Child>){

        var optionsAdapter= FieldsAdapter<Child>(onOptionClickListener)
        optionsAdapter.setItemsList(items)
        _rvOptions.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        _rvOptions.adapter=optionsAdapter
        _rvOptions.isNestedScrollingEnabled=false
    }
    private fun showSubOptions(items:ArrayList<Child>){

        var optionsAdapter= FieldsAdapter<Child>(onSubOptionClickListener)
        optionsAdapter.setItemsList(items)
        _rvSubOptions.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        _rvSubOptions.adapter=optionsAdapter
        _rvSubOptions.isNestedScrollingEnabled=false
    }
    private fun events(){
       binding.apply {

           etMainCategory.setOnClickListener {
                var onClick=object :RecycleViewEventListener{
                   override fun onClick(obj: Any) {
                      var category:MainCategory=obj as MainCategory
                       etMainCategory.setText(category.name)
                       //
                       selectedData= SelectedData()
                       selectedData.mainCategory= MainCategory(category.id,category.name)
                       //
                       etSubCategory.text=""
                       rvProperties.adapter=null


                   }

               }
                var action =HomeFragmentDirections.actionHomeFragmentToDetailsFragment(OperationTypes.DisplayMainCategory,onClick,-1)
               findNavController().navigate(action)
           }
           etSubCategory.setOnClickListener {
               var onClick=object :RecycleViewEventListener{
                   override fun onClick(obj: Any) {
                       var category:SubCategory=obj as SubCategory
                       etSubCategory.setText(category.name)
                       //
                       addProductViewModel.getProperties(category.id!!)
                       //
                       selectedData.mainCategory?.subCategories?.add(SubCategory(id=category.id!!,name=category.name!!))
                   }

               }
               var action =HomeFragmentDirections.actionHomeFragmentToDetailsFragment(OperationTypes.DisplaySubCategory,onClick,selectedData.mainCategory?.id!!)
               findNavController().navigate(action)
           }
           onPropertyClickListener=object :RecycleViewEventListener{
               override fun onClick(obj: Any, label:TextView, rvOptions: RecyclerView) {
                   val p=obj as Property

                   val onClickList=object :RecycleViewEventListener{
                       override fun onClick(obj: Any) {
                           val selected=obj as Option
                           label.text=selected.name
                           _rvOptions=rvOptions
                           addProductViewModel.getOptionChildren(selected.id!!)

                           /// checking property if already added or not
                           var count=0
                           selectedData.properties?.forEach {
                               if(it.info.id==p.id){
                                   it.value=selected.name!!
                                   count=1
                               }
                           }
                           if(count==0){
                               var property=Property(id=p.id,name=p.name)
                               selectedData.properties?.add(SelectedProperty(info = property,selected.name!!))

                           }

                       }

                   }

                   var action =HomeFragmentDirections.actionHomeFragmentToDetailsFragment(OperationTypes.DisplayPropertyOptions,onClickList,p.id!!)
                   findNavController().navigate(action)
               }

           }
           onOptionClickListener=object :RecycleViewEventListener{
               override fun onClick(obj: Any,label:TextView,rvOptions: RecyclerView,otherValue: EditText, otherLabel:TextView) {
                   var ch=obj as Child
                   var onClickList=object :RecycleViewEventListener{
                       override fun onClick(obj: Any) {
                           var selected=obj as Option
                           label.text=selected.name
                           _rvSubOptions=rvOptions

                           if(selected.id==-100){
                               otherValue.visibility=View.VISIBLE
                               otherLabel.visibility=View.VISIBLE
                               otherValue.setText("")
                           }else{
                               otherValue.visibility=View.GONE
                               otherLabel.visibility=View.GONE
                               ///////////////////
                               var option=Option(ch.id,ch.name)
                               var propertyID=getCurrentProperty(ch.parent!!)
                               selectedData.properties?.forEach {
                                   if(it.info.id==propertyID){
                                       it?.options?.add(SelectedOption(option,selected.name!!, parent = propertyID))
                                   }
                               }
                               ///////////////////
                               addProductViewModel.getChildOptions(selected.id!!)
                           }

                       }

                   }

                   var action =HomeFragmentDirections.actionHomeFragmentToDetailsFragment(OperationTypes.DisplayOptionOptions,onClickList,ch.id!!)
                   findNavController().navigate(action)
               }

           }
           onSubOptionClickListener=object :RecycleViewEventListener{

               override fun onClick(obj: Any,label:TextView,rvOptions: RecyclerView,otherValue: EditText, otherLabel:TextView) {
                   var ch=obj as Child
                   var onClickList=object :RecycleViewEventListener{
                       override fun onClick(obj: Any) {
                           var selected=obj as Option
                           label.text=selected.name


                           if(selected.id==-100){
                               otherValue.visibility=View.VISIBLE
                               otherLabel.visibility=View.VISIBLE
                               otherValue.setText("")
                           }else{
                               otherValue.visibility=View.GONE
                               otherLabel.visibility=View.GONE
                               ///////////////////
                               var option=Option(ch.id,ch.name)
                               var currentOption=getCurrentOption(ch?.parent!!)
                               selectedData.properties?.forEach { pro->
                                   pro.options?.forEach { opt->
                                         if(opt.info.id==currentOption.id){
                                             opt?.options?.add(SelectedOption(option,selected.name!!, parent = currentOption.id!!))
                                         }
                                   }
                               }

                               ///////////////////

                           }






                       }

                   }
                   var action =HomeFragmentDirections.actionHomeFragmentToDetailsFragment(OperationTypes.DisplaySubOptionOptions,onClickList,ch.id!!)
                   findNavController().navigate(action)
               }
           }
           btnShow.setOnClickListener {

               if(selectedData!==null) {
                   var action =
                       HomeFragmentDirections.actionHomeFragmentToResultFragment(selectedData)
                   findNavController().navigate(action)
               }
           }

       }

   }

    private fun getCurrentProperty(id:Int):Int{
        var propertyID=0
        addProductViewModel.propertiesResponseLive.value?.let {
            var properties=  it.data as ArrayList<Property>

            properties.forEach { p->
                p.options.forEach { option->
                    if(option.id==id){
                        propertyID=p.id!!
                    }
                }

            }
        }
        return propertyID
    }
    private fun getCurrentOption(id:Int):Child{

        var _child:Child=Child()
        addProductViewModel.optionChildrenResponseLive.value?.let {
            var children=  it.data as ArrayList<Child>

            children.forEach { ch->
                ch.options.forEach { option->
                    if(option.id==id){
                        _child=ch
                        
                    }
                }

            }
        }
        return _child
    }


}




