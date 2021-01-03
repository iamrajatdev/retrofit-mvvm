package com.example.retrofitmvvmtest.data.repository

import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.retrofit.RetrofitRequest
import com.example.retrofitmvvmtest.model.retrofit.UserRetrofitRequest


class PageStoreRepository {

    suspend fun getPost() = RetrofitRequest.api.fetchData(2)
    suspend fun getLogin(loginRequest: LoginRequest) = UserRetrofitRequest.loginApi.login(loginRequest)
}