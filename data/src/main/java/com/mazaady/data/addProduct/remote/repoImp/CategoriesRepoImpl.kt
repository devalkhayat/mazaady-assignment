package com.mazaady.data.addProduct.remote.repoImp
import com.mazaady.data.addProduct.remote.EndPoints
import com.mazaady.data.common.RetrofitBuilder
import com.mazaady.domain.addProduct.repositories.CategoriesRepo
import com.mazaady.domain.addProduct.responses.CategoriesResponse
import com.mazaady.domain.common.BaseResponse
import com.mazaady.domain.common.FinalResponse

class CategoriesRepoImpl(private val retrofitBuilder: RetrofitBuilder): CategoriesRepo {


    private val endPoints=retrofitBuilder.start()?.create(EndPoints::class.java)

    override suspend fun getAll(): FinalResponse<CategoriesResponse>{
        try {

            val result =  endPoints?.getAllCategories()

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