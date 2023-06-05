package com.mazaady.data.addProduct.remote

import com.mazaady.domain.addProduct.models.Property
import com.mazaady.domain.addProduct.responses.CategoriesResponse
import com.mazaady.domain.addProduct.models.Child
import com.mazaady.domain.common.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoints {

    @GET("get_all_cats")
    suspend fun getAllCategories():Response<BaseResponse<CategoriesResponse>>
    @GET("properties")
    suspend fun getProperties(@Query("cat") cat:Int):Response<BaseResponse<ArrayList<Property>>>
    @GET("get-options-child/{id}")
    suspend fun getOptionChildren(@Path("id") option:Int):Response<BaseResponse<ArrayList<Child>>>
}