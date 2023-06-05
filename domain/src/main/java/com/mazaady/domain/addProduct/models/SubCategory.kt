package com.mazaady.domain.addProduct.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SubCategory (

  @SerializedName("id"               ) var id              : Int?    = null,
  @SerializedName("name"             ) var name            : String? = null,


): Serializable