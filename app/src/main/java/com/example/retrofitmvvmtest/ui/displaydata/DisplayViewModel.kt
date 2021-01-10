package com.example.retrofitmvvmtest.ui.displaydata

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvmtest.data.repository.PageStoreRepository
import com.example.retrofitmvvmtest.model.response.PageResponse
import com.example.retrofitmvvmtest.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DisplayViewModel(application: Application) : AndroidViewModel(application) {

    var loginResponse = MutableLiveData<Resource<PageResponse?>>()
    private val repository = PageStoreRepository(application)

    fun fetchPost(pages: Int) {
        loginResponse.postValue(Resource.Loading())

        viewModelScope.launch(Dispatchers.IO) {
            Log.e("TAG", "fetchPost: came here")
            val response = repository.getPost(pages)
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.e("Response :::", "fetchPost: ${response.body()}")
                    repository.deletePages()
                    repository.insertPageData(response.body()!!)
                    Log.e("After inserting", "fetchPost: ")
                    loginResponse.postValue(Resource.Success(response.body()))
                }
            } else {
                loginResponse.postValue(Resource.Error("Invalid response"))
            }
        }
    }

    fun getPageResponse() = repository.getAllPageData()
}