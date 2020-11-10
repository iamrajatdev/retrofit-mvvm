package com.example.retrofitmvvmtest

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager

class MainActivity : Application() {

    override fun onCreate() {
        super.onCreate()

        @SuppressLint("MissingPermission")
        fun isNetworkConnected(): Boolean {
            val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork?.isConnected ?: false
        }
    }
}