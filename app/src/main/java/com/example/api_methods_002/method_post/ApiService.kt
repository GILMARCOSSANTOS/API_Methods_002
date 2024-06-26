package com.example.api_methods_002.method_post

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("posts")
    fun createPost(@Body post: PostRequest): Call<PostResponse>
}
