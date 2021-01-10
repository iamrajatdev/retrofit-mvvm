package com.example.retrofitmvvmtest.model.remote

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

object NetWorkConnection {

    @SuppressLint("MissingPermission")
    fun isNetworkConnected(context: Context): Boolean {
        val connectionManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectionManager.activeNetworkInfo

        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }
}

