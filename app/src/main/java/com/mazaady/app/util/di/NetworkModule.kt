package com.mazaady.app.util.di

import com.mazaady.data.common.RetrofitBuilder
import org.koin.dsl.module

val NetworkModule = module {
    single { RetrofitBuilder() }
}