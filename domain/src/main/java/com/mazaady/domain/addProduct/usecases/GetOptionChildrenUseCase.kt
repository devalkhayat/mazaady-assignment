package com.mazaady.domain.addProduct.usecases

import com.mazaady.domain.addProduct.repositories.PropertiesRepo


class GetOptionChildrenUseCase(private val propertiesRepo: PropertiesRepo) {
    suspend operator fun invoke(option:Int)=propertiesRepo.getOptionChildren(option )
}
