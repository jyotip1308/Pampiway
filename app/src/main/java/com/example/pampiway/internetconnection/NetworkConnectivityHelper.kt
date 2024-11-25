package com.example.pampiway.internetconnection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkRequest
import android.util.Log

class NetworkConnectivityHelper(
    private val context: Context,
    private val onConnectionChanged: (Boolean) -> Unit
) {

    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private val networkCallbackHandler = NetworkCallbackHandler(onConnectionChanged)

    fun registerNetworkCallback() {
        val networkRequest = NetworkRequest.Builder().build()
        connectivityManager.registerNetworkCallback(networkRequest, networkCallbackHandler)
        Log.d("NetworkConnectivityHelper", "Network callback registered")
    }

    fun unregisterNetworkCallback() {
        connectivityManager.unregisterNetworkCallback(networkCallbackHandler)
        Log.d("NetworkConnectivityHelper", "Network callback unregistered")
    }
}
