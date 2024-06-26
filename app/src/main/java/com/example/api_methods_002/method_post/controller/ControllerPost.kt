package com.example.api_methods_002.method_post.controller

import android.content.Context
import com.example.api_methods_002.method_post.model.SigninErrorsKeys
import com.example.api_methods_002.method_post.model.SigninPostModelBody
import com.example.api_methods_002.method_post.model.SigninPostModelError
import com.example.api_methods_002.method_post.model.SigninPostModelResponse
import com.example.api_methods_002.method_post.model.SigninResponseErrorConvert
import com.example.api_methods_002.method_post.service.ListenerSigninResponse
import com.example.api_methods_002.method_post.service.SigninPostService

import com.example.api_methods_002.service_main.ApiConnection
import retrofit2.Callback
import retrofit2.Response

class SigninController(context: Context) {

    private val connectApi = ApiConnection(context)
    private val errorTransform = SigninResponseErrorConvert(context)

    fun fetchSignin(body: SigninPostModelBody, signinListener: ListenerSigninResponse) {

        val service = connectApi.createService(SigninPostService::class.java)
        val call: retrofit2.Call<SigninPostModelResponse> = service.postSignin(body)

        call.enqueue(object : Callback<SigninPostModelResponse> {

            override fun onFailure(call: retrofit2.Call<SigninPostModelResponse>, t: Throwable) {

                signinListener.errorResponse(t.message.toString(), SigninPostModelError())
            }

            override fun onResponse(
                call: retrofit2.Call<SigninPostModelResponse>,
                response: Response<SigninPostModelResponse>
            ) {

                if (response.body()?.token !== null) {
                    signinListener.successResponse(response.body()!!)

                } else {

                    val error = errorTransform.parseError(response)
                    val msg = error.code ?: "generic_error"

                    SigninErrorsKeys.errorsMap["${msg}"]?.let {

                        signinListener.errorResponse(it, SigninPostModelError())
                    }
                }
            }
        })
    }
}