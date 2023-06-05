package com.mazaady.app.util.di

import com.mazaady.app.features.addProduct.viewmodels.AddProductViewModel
import com.mazaady.app.features.auctionDetails.viewmodels.AuctionDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val ViewModelModule = module {
    viewModel{ AddProductViewModel(get(),get(),get()) }
    viewModel{ AuctionDetailsViewModel(get()) }
}