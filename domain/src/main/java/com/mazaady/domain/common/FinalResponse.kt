package com.mazaady.domain.common

data class FinalResponse<T>(
    val data: Any? =null,
    val status: Boolean? = null,
    val message: String? = null,
)
