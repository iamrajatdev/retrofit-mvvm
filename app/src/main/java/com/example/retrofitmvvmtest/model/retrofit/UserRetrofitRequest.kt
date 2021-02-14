package com.example.retrofitmvvmtest.model.retrofit

import com.example.retrofitmvvmtest.model.remote.UserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
<<<<<<< HEAD
import java.util.concurrent.TimeUnit
=======
>>>>>>> room-implementation


object UserRetrofitRequest {

    private val retrofitLogin by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val loginApi: UserService by lazy {
        retrofitLogin!!.create(UserService::class.java)
    }
<<<<<<< HEAD
=======

    val pageApi: UserService by lazy {
        retrofitLogin!!.create(UserService::class.java)
    }
>>>>>>> room-implementation
}