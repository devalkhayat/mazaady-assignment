package com.mazaady.app.util.models

import com.mazaady.domain.addProduct.models.Child
import com.mazaady.domain.addProduct.models.Option
//Brand:BMW->Model:S55
data class SelectedOption(
    var info:Option,
    var value:String,
    var parent:Int,
    var options:ArrayList<SelectedOption>?= arrayListOf()

)
