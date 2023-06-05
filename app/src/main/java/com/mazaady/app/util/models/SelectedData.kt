package com.mazaady.app.util.models

import com.mazaady.domain.addProduct.models.MainCategory
import com.mazaady.domain.addProduct.models.Property
import java.io.Serializable

data class SelectedData(
    var mainCategory:MainCategory?=null,
    var properties:MutableList<SelectedProperty>?= mutableListOf(),
    ): Serializable