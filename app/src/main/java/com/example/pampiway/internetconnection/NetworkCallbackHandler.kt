package com.example.pampiway.internetconnection

import android.net.ConnectivityManager
import android.net.Network
import android.util.Log

class NetworkCallbackHandler(
    private val onConnectionChanged: (Boolean) -> Unit
) : ConnectivityManager.NetworkCallback() {

    override fun onAvailable(network: Network) {
        Log.d("NetworkCallbackHandler", "Network available")
        onConnectionChanged(true)
    }

    override fun onLost(network: Network) {
        Log.d("NetworkCallbackHandler", "Network lost")
        onConnectionChanged(false)
    }
}
