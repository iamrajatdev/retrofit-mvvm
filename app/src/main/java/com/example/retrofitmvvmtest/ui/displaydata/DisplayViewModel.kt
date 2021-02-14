package com.example.retrofitmvvmtest.ui.displaydata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
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
            val response = repository.getPost(pages)
            if (response.isSuccessful) {
                response.body()?.let {
                    repository.deletePages()
                    repository.insertPageData(response.body()!!)
                    loginResponse.postValue(Resource.Success(response.body()))
                }
            } else {
                loginResponse.postValue(Resource.Error("Invalid response"))
            }
        }
    }

    fun getPageResponse() = repository.getAllPageData()
}