package com.example.api_methods_002.method_get.service

import com.example.api_methods_002.method_get.model.ModelGetItem

interface GetResponse {

    fun successResponseGet(successGet: List<ModelGetItem>){

    }

    fun errorResponseGet(errorGet: String){

    }
}