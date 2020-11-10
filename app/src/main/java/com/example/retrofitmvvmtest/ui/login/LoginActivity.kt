package com.example.retrofitmvvmtest.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.retrofitmvvmtest.R
import com.example.retrofitmvvmtest.databinding.ActivityLoginBinding
import com.example.retrofitmvvmtest.model.request.LoginRequest

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityLoginBinding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        loginViewModel.checkInternetConnectionWithMessage(this)
        activityLoginBinding.viewmodel = loginViewModel
        activityLoginBinding.btnLogin.setOnClickListener {
            val loginRequest = LoginRequest(
                activityLoginBinding.txtEmailAddress.text.toString(),
                activityLoginBinding.txtPassword.text.toString()
            )
            loginViewModel.fetchLogin(loginRequest)
        }

        loginViewModel.toastMessage.observe(this,
            { message ->
                Toast.makeText(
                    this@LoginActivity,
                    message,
                    Toast.LENGTH_SHORT
                ).show()
            })

        loginViewModel.toastNetwork.observe(this, {
            Toast.makeText(this@LoginActivity, it, Toast.LENGTH_SHORT).show()
        })
    }
}