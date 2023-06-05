package com.mazaady.data.addProduct.remote.repoImp

import com.mazaady.data.addProduct.remote.EndPoints
import com.mazaady.data.common.RetrofitBuilder
import com.mazaady.domain.addProduct.models.Property
import com.mazaady.domain.addProduct.repositories.PropertiesRepo
import com.mazaady.domain.addProduct.models.Child
import com.mazaady.domain.common.FinalResponse

class PropertiesRepoImpl (private val retrofitBuilder: RetrofitBuilder): PropertiesRepo {
    private val endPoints=retrofitBuilder.start()?.create(EndPoints::class.java)
    override suspend fun getAll(subCategoryID: Int): FinalResponse<ArrayList<Property>> {

        try {

            val result =  endPoints?.getProperties(subCategoryID)

            result.let {

                when (it?.code()) {
                    //Success

                    200 ->  {
                        return FinalResponse(data =it.body()!!.data!!, status = true)
                    }

                    else -> {
                        return FinalResponse(message = result?.message(), status = false)
                    }
                }

            }


        }catch (ex:Exception){

            return FinalResponse( message = ex.message!!, status = false)
        }
    }

    override suspend fun getOptionChildren(option: Int): FinalResponse<ArrayList<Child>> {

        try {

            val result =  endPoints?.getOptionChildren(option)

            result.let {

                when (it?.code()) {
                    //Success

                    200 ->  {
                        return FinalResponse(data =it.body()!!.data!!, status = true)
                    }

                    else -> {
                        return FinalResponse(message = result?.message(), status = false)
                    }
                }

            }


        }catch (ex:Exception){

            return FinalResponse( message = ex.message!!, status = false)
        }
    }


}