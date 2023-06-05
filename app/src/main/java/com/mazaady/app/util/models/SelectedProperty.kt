package com.mazaady.app.util.models

import com.mazaady.domain.addProduct.models.Property
//Brand:BMW
data class SelectedProperty(
    var info:Property,
    var value:String,
    var options:ArrayList<SelectedOption>? = arrayListOf()
)
