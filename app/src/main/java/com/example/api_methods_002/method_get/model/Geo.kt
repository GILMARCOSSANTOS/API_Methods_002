package com.example.api_methods_002.method_get.model

import com.google.gson.annotations.SerializedName

data class Geo(

    @SerializedName("lat")
    val lat: String,

    @SerializedName("lng")
    val lng: String
)