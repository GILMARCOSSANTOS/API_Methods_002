package com.example.api_methods_002.get.model

interface GetResponse {

    fun successResponseGet(successGet: List<ModelGetItem>){

    }

    fun errorResponseGet(errorGet: String){

    }
}