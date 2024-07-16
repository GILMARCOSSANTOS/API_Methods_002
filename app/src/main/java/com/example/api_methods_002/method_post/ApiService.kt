package com.example.api_methods_002.method_post

import com.example.api_methods_002.method_get.model.ModelGetItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("posts")
    fun createPost(@Body post: ModelPostRequest): Call<ModelPostResponse>
}
