package com.mazaady.domain.addProduct.models

import com.google.gson.annotations.SerializedName

data class Child(
    @SerializedName("id"          ) var id          : Int?               = null,
    @SerializedName("name"        ) var name        : String?            = null,
    @SerializedName("parent"   )    var parent       : Int?              = null,
    @SerializedName("options"     ) var options     : ArrayList<Option> = arrayListOf()
)
