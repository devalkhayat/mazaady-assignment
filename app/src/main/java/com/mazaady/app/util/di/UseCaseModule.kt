package com.mazaady.app.util.di

import com.mazaady.domain.addProduct.usecases.GetAllCategoriesUseCase
import com.mazaady.domain.addProduct.usecases.GetPropertiesUseCase
import com.mazaady.domain.addProduct.usecases.GetOptionChildrenUseCase
import com.mazaady.domain.auctionDetails.usecases.GetDetailsUseCase
import org.koin.dsl.module

val UseCaseModule= module {
    single<GetAllCategoriesUseCase> {GetAllCategoriesUseCase(get())  }
    single<GetPropertiesUseCase> {GetPropertiesUseCase(get())  }
    single<GetOptionChildrenUseCase> {GetOptionChildrenUseCase(get())  }
    single<GetDetailsUseCase> {GetDetailsUseCase(get())  }
}