package com.mazaady.domain.addProduct.responses

import com.google.gson.annotations.SerializedName
import com.mazaady.domain.addProduct.models.MainCategory

data class CategoriesResponse (
    @SerializedName("categories"         ) var categories       : ArrayList<MainCategory> = arrayListOf(),
)

