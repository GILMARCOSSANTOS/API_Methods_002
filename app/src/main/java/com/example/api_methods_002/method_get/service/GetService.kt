package com.example.api_methods_002.method_get.service

import com.example.api_methods_002.method_get.model.ModelGetItem
import retrofit2.http.GET

interface GetService {

    @GET("users")
    fun getService(): retrofit2.Call<List<ModelGetItem>>
}