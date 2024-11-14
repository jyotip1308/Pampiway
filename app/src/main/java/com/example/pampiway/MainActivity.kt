package com.example.pampiway

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pampiway.navigationScreen.Navigation
import com.example.pampiway.network.NetworkConnectivityHelper
import com.example.pampiway.ui.theme.PampiwayTheme
import com.google.android.material.snackbar.Snackbar


class MainActivity : ComponentActivity() {

    private lateinit var networkConnectivityHelper: NetworkConnectivityHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        networkConnectivityHelper = NetworkConnectivityHelper(this) { isConnected ->
            showNetworkToast(isConnected)
        }

        enableEdgeToEdge()
        setContent {
            PampiwayTheme {
                Navigation()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        networkConnectivityHelper.registerNetworkCallback()
    }

    override fun onStop() {
        super.onStop()
        networkConnectivityHelper.unregisterNetworkCallback()
    }

    private fun showNetworkToast(isConnected: Boolean) {
        val message = if (isConnected) "Connected" else "Connection Lost"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
