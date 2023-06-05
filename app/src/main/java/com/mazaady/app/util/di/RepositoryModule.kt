package com.mazaady.app.util.di

import com.mazaady.data.addProduct.remote.repoImp.CategoriesRepoImpl
import com.mazaady.data.addProduct.remote.repoImp.PropertiesRepoImpl
import com.mazaady.data.auctionDetails.local.repoImpl.AuctionDetailsRepoImpl
import com.mazaady.domain.addProduct.repositories.CategoriesRepo
import com.mazaady.domain.addProduct.repositories.PropertiesRepo
import com.mazaady.domain.auctionDetails.repositories.DetailsRepo
import org.koin.dsl.module


val RepositoryModule=module{

    single<CategoriesRepo> { CategoriesRepoImpl(get()) }
    single<PropertiesRepo> { PropertiesRepoImpl(get()) }
    single<DetailsRepo> { AuctionDetailsRepoImpl() }
}