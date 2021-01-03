package com.example.retrofitmvvmtest.model.remote

import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.request.PageRequest
import com.example.retrofitmvvmtest.model.response.LoginResponse
import com.example.retrofitmvvmtest.model.response.PageResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    @POST("api/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("api/users")
    suspend fun fetchData(@Query("page") pages: Int): Response<PageResponse>
}