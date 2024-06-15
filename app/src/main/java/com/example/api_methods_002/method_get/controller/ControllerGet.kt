package com.example.api_methods_002.method_get.controller

import com.example.api_methods_002.method_get.model.ModelGetItem
import com.example.api_methods_002.method_get.service.GetResponse
import com.example.api_methods_002.method_get.service.GetService
import com.example.api_methods_002.service_main.ApiConnection
import retrofit2.Call
import retrofit2.Response

class ControllerGet() {

    private val apiConnection = ApiConnection()

    fun controllerGet(returnResponseGet: GetResponse) {

        val service = apiConnection.createService(GetService::class.java)
        val call: Call<List<ModelGetItem>> = service.getService()

        call.enqueue(object : retrofit2.Callback<List<ModelGetItem>> {

            override fun onResponse(
                call: Call<List<ModelGetItem>>,
                response: Response<List<ModelGetItem>>
            ) {

                response.body()?.let {

                    val apiData = response.body()
                    returnResponseGet.successResponseGet(it)
                    println("Resposta de Sucesso GET = $apiData")
                }
            }

            override fun onFailure(call: Call<List<ModelGetItem>>, t: Throwable) {

                println("Resposta de Erro ControllerGet = ${t.message}")
            }
        })
    }
}