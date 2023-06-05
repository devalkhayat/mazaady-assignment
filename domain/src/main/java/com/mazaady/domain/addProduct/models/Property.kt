package com.mazaady.domain.addProduct.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Property(
    @SerializedName("id"          ) var id          : Int?               = null,
    @SerializedName("name"        ) var name        : String?            = null,
    @SerializedName("options"     ) var options     : ArrayList<Option> = arrayListOf()
): Serializable