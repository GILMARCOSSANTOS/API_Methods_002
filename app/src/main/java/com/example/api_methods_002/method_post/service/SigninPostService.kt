package com.example.api_methods_002.method_post.service

import com.example.api_methods_002.method_post.model.PostModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PostService {

    @POST("posts")
    fun postUser(@Body user: PostModel): Call<PostModel>
}

