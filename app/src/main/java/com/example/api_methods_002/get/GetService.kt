package com.example.api_methods_002.get

import com.example.api_methods_002.get.model.ModelGetItem
import retrofit2.http.GET

interface GetService {

    @GET("users")
    fun getService(): retrofit2.Call<List<ModelGetItem>>
}