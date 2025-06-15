package com.example.retrofitbe

import com.google.gson.annotations.SerializedName

data class PostModelRequest(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)