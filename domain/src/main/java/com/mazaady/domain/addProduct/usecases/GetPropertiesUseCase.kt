package com.mazaady.domain.addProduct.usecases

import com.mazaady.domain.addProduct.repositories.CategoriesRepo
import com.mazaady.domain.addProduct.repositories.PropertiesRepo


class GetPropertiesUseCase(private val propertiesRepo: PropertiesRepo) {
    suspend operator fun invoke(subCategoryID:Int)=propertiesRepo.getAll(subCategoryID)
}
