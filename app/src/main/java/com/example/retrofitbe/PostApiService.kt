package com.example.retrofitbe

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostModelResponse>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Response<PostModelResponse>

    @Headers("Content-type': 'application/json; charset=UTF-8")
    @POST("posts")
    suspend fun insertPost(@Body post: PostModelRequest): Response<PostModelResponse>

}