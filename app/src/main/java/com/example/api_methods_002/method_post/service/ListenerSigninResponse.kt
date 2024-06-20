package com.example.api_methods_002.method_post.service

import com.example.api_methods_002.method_post.model.SigninPostModelError
import com.example.api_methods_002.method_post.model.SigninPostModelResponse

interface ListenerSigninResponse {

    fun errorResponse(message: String, signinEroor: SigninPostModelError)

    fun successResponse(signinResponse: SigninPostModelResponse)
}