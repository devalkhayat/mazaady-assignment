package com.mazaady.domain.common

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(

    @SerializedName("code" ) var code : Int?    = null,
    @SerializedName("msg"  ) var msg  : String? = null,
    @SerializedName("data" ) var data : T?
)
