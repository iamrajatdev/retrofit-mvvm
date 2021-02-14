package com.example.retrofitmvvmtest.model.remote

<<<<<<< HEAD
import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.request.PageRequest
import com.example.retrofitmvvmtest.model.response.LoginResponse
import com.example.retrofitmvvmtest.model.response.PageResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
=======
import androidx.annotation.NonNull
import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.response.LoginResponse
import com.example.retrofitmvvmtest.model.response.PageResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
>>>>>>> room-implementation

interface UserService {

    @POST("api/login")
<<<<<<< HEAD
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
=======
    suspend fun login(@Body @NonNull loginRequest: LoginRequest): Response<LoginResponse>
>>>>>>> room-implementation

    @GET("api/users")
    suspend fun fetchData(@Query("page") pages: Int): Response<PageResponse>
}