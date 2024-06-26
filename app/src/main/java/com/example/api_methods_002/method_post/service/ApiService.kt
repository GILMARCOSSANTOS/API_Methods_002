package com.example.api_methods_002.method_post.service

import com.example.api_methods_002.method_post.model.PostRequest
import com.example.api_methods_002.method_post.model.PostResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("posts")
    fun createPost(@Body post: PostRequest): Call<PostResponse>
}