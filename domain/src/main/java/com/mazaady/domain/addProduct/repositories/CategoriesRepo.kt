package com.mazaady.domain.addProduct.repositories

import com.mazaady.domain.addProduct.responses.CategoriesResponse
import com.mazaady.domain.common.FinalResponse

interface CategoriesRepo {

    suspend fun getAll(): FinalResponse<CategoriesResponse>
}