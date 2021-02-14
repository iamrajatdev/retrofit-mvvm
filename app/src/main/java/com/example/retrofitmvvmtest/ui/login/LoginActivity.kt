package com.example.retrofitmvvmtest.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvmtest.R
import com.example.retrofitmvvmtest.databinding.ActivityLoginBinding
import com.example.retrofitmvvmtest.model.request.LoginRequest
import com.example.retrofitmvvmtest.ui.displaydata.DisplayActivity
import com.example.retrofitmvvmtest.utils.Resource

class LoginActivity : AppCompatActivity() {

    private lateinit var activityLoginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this@LoginActivity).get(LoginViewModel::class.java)
        activityLoginBinding.viewmodel = loginViewModel
    }

    fun loginClick(view: View) {
        val email = activityLoginBinding.txtEmailAddress.text.toString()
        val password = activityLoginBinding.txtPassword.text.toString()
        val loginRequest = LoginRequest(email, password)

        if (email.isNotEmpty() || password.isNotEmpty()) {
            loginViewModel.fetchLogin(loginRequest)
        }

        loginViewModel.loginResponse.observe(this, { message ->
            when (message) {
                is Resource.Success -> {
                    startActivity(Intent(this@LoginActivity, DisplayActivity::class.java))
                }

                is Resource.Error -> {
                    message.message?.let { message ->
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun showProgressBar() {
        activityLoginBinding.progress.visibility = View.VISIBLE
    }

}