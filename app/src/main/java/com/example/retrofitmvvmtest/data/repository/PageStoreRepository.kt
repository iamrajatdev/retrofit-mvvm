package com.example.retrofitmvvmtest.data.repository

<<<<<<< HEAD
import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.retrofit.RetrofitRequest
import com.example.retrofitmvvmtest.model.retrofit.UserRetrofitRequest


class PageStoreRepository {

    suspend fun getPost() = RetrofitRequest.api.fetchData(2)
    suspend fun getLogin(loginRequest: LoginRequest) = UserRetrofitRequest.loginApi.login(loginRequest)
=======
import android.content.Context
import android.util.Log
import com.example.retrofitmvvmtest.data.localdb.DatabaseService
import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.response.PageResponse
import com.example.retrofitmvvmtest.model.response.UserResponse
import com.example.retrofitmvvmtest.model.retrofit.UserRetrofitRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PageStoreRepository(context: Context) {

    private val pageDao = DatabaseService.getInstance(context)!!.pageDao()

    suspend fun getPost(pages: Int) = UserRetrofitRequest.pageApi.fetchData(pages)
    suspend fun getLogin(loginRequest: LoginRequest) =
        UserRetrofitRequest.loginApi.login(loginRequest)

    suspend fun insertPageData(pageBody: PageResponse) {
        pageDao.insertAll(pageBody)
    }

    fun getAllPageData() = pageDao.fetchAllDataFromPages()
    suspend fun deletePages() = pageDao.deletePage()
>>>>>>> room-implementation
}