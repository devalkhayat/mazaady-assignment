package com.mazaady.domain.addProduct.usecases

import com.mazaady.domain.addProduct.repositories.CategoriesRepo


class GetAllCategoriesUseCase(private val categoriesRepo: CategoriesRepo) {
    suspend operator fun invoke()=categoriesRepo.getAll()
}
