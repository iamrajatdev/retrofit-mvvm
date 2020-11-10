package com.example.retrofitmvvmtest.model.remote

import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("api/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse?>
}