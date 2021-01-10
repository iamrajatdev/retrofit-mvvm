package com.example.retrofitmvvmtest.model.remote

import androidx.annotation.NonNull
import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.response.LoginResponse
import com.example.retrofitmvvmtest.model.response.PageResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @POST("api/login")
    suspend fun login(@Body @NonNull loginRequest: LoginRequest): Response<LoginResponse>

    @GET("api/users")
    suspend fun fetchData(@Query("page") pages: Int): Response<PageResponse>
}