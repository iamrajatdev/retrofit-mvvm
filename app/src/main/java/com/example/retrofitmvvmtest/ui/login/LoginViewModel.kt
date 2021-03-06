package com.example.retrofitmvvmtest.ui.login

import android.app.Application
<<<<<<< HEAD
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvmtest.MainActivity
=======
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
>>>>>>> room-implementation
import com.example.retrofitmvvmtest.data.repository.PageStoreRepository
import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.response.LoginResponse
import com.example.retrofitmvvmtest.utils.Resource
import com.example.retrofitmvvmtest.utils.Utils
import kotlinx.coroutines.launch
<<<<<<< HEAD
import java.io.IOException
=======
>>>>>>> room-implementation

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    var loginResponse = MutableLiveData<Resource<LoginResponse>>()
<<<<<<< HEAD
    private var repository: PageStoreRepository = PageStoreRepository()
=======
    private var repository: PageStoreRepository = PageStoreRepository(application)
>>>>>>> room-implementation

    fun fetchLogin(loginRequest: LoginRequest) {
        loginResponse.postValue(Resource.Loading())

        if (Utils.hasInternetConnection(getApplication())) {
            viewModelScope.launch {
                val response = repository.getLogin(loginRequest)
                if (response.isSuccessful) {
                    response.body()?.let {
                        loginResponse.postValue(Resource.Success(it))
                    }
                } else {
                    loginResponse.postValue(Resource.Error("Error response"))
                }
            }
        } else {
            loginResponse.postValue(Resource.Error("No internet"))
        }
    }
}
