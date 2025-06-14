package com.example.retrofitbe

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostModelResponse>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Response<PostModelResponse>

}