package com.mazaady.domain.addProduct.repositories

import com.mazaady.domain.addProduct.models.Property
import com.mazaady.domain.addProduct.models.Child
import com.mazaady.domain.common.FinalResponse

interface PropertiesRepo {

    suspend fun getAll(subCategoryID:Int): FinalResponse<ArrayList<Property>>
    suspend fun getOptionChildren(option:Int): FinalResponse<ArrayList<Child>>
}