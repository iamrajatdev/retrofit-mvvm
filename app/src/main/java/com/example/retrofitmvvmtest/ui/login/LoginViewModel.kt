package com.example.retrofitmvvmtest.ui.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvmtest.model.remote.NetWorkConnection
import com.example.retrofitmvvmtest.model.remote.UserService
import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.model.response.LoginResponse
import com.example.retrofitmvvmtest.model.retrofit.RetrofitRequest
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    var toastMessage = MutableLiveData<String>()
    var toastNetwork = MutableLiveData<String>()
    private var userService: UserService? = RetrofitRequest.getRetrofitInstance()?.create(UserService::class.java)

    fun fetchLogin(loginRequest: LoginRequest) {
        val call: Call<LoginResponse?>? = userService?.login(loginRequest)
        call?.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    toastMessage.setValue("User Success")
                } else {
                    try {
                        val jsonObject = JSONObject(response.errorBody().string())
                        toastMessage.setValue(jsonObject.getString("error"))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {}
        })
    }

    fun checkInternetConnectionWithMessage(context: Context): Boolean =
        if (NetWorkConnection.isNetworkConnected(context)) {
            true
        } else {
            toastNetwork.postValue("Error network")
            false
        }
}
