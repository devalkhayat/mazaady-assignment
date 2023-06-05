package com.mazaady.app.features.addProduct.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mazaady.domain.addProduct.models.Property
import com.mazaady.domain.addProduct.responses.CategoriesResponse
import com.mazaady.domain.addProduct.models.Child
import com.mazaady.domain.addProduct.usecases.GetAllCategoriesUseCase
import com.mazaady.domain.addProduct.usecases.GetPropertiesUseCase
import com.mazaady.domain.addProduct.usecases.GetOptionChildrenUseCase
import com.mazaady.domain.common.FinalResponse
import kotlinx.coroutines.launch

class AddProductViewModel(private val getAllCategoriesUseCase: GetAllCategoriesUseCase,private val getPropertiesUseCase:GetPropertiesUseCase,private val getOptionChildrenUseCase:GetOptionChildrenUseCase): ViewModel() {

    private  val TAG = "AddProductViewModel"
    private val categoriesResponse= MutableLiveData<FinalResponse<CategoriesResponse>?>()
    val categoriesResponseLive: MutableLiveData<FinalResponse<CategoriesResponse>?>
        get() = categoriesResponse


    private val propertiesResponse= MutableLiveData<FinalResponse<ArrayList<Property>>?>()
    val propertiesResponseLive: MutableLiveData<FinalResponse<ArrayList<Property>>?>
        get() = propertiesResponse

    private val optionChildrenResponse= MutableLiveData<FinalResponse<ArrayList<Child>>?>()
    val optionChildrenResponseLive: MutableLiveData<FinalResponse<ArrayList<Child>>?>
        get() = optionChildrenResponse


    private val childOptionsResponse= MutableLiveData<FinalResponse<ArrayList<Child>>?>()
    val childOptionsResponseLive: MutableLiveData<FinalResponse<ArrayList<Child>>?>
        get() = childOptionsResponse
    fun getAllCategories() {
        viewModelScope.launch {
           categoriesResponse.postValue(getAllCategoriesUseCase())
        }
    }

    fun getProperties(subCategoryID:Int) {
        viewModelScope.launch {
            propertiesResponse.postValue(getPropertiesUseCase(subCategoryID))
        }
    }

    fun getOptionChildren(option:Int) {
        viewModelScope.launch {
            optionChildrenResponse.postValue(getOptionChildrenUseCase(option))
        }
    }
    fun getChildOptions(child:Int) {
        viewModelScope.launch {
            childOptionsResponse.postValue(getOptionChildrenUseCase(child))
        }
    }
}