package com.example.pampiway

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.pampiway.components.Add_DeviceDialog
import com.example.pampiway.navigationScreen.Navigation
import com.example.pampiway.internetconnection.NetworkConnectivityHelper
import com.example.pampiway.network.AuthAPIs
import com.example.pampiway.network.RetrofitBuilder
import com.example.pampiway.repository.AuthRepo
import com.example.pampiway.ui.theme.PampiwayTheme
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.viewmodel.MainViewModel
import com.example.pampiway.viewmodel.MainViewModelFactory


class MainActivity : ComponentActivity() {

    val context = this

    private lateinit var networkConnectivityHelper: NetworkConnectivityHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        networkConnectivityHelper = NetworkConnectivityHelper(this) { isConnected ->
            showNetworkToast(isConnected)
        }


        MyComponents.authAPI = RetrofitBuilder.create().create(AuthAPIs::class.java)
        MyComponents.authRepo = AuthRepo(authAPIs = MyComponents.authAPI, context)
        MyComponents.mainViewModelFactory = MainViewModelFactory(authRepo = MyComponents.authRepo,context)
        MyComponents.mainViewModel = MyComponents.mainViewModelFactory.create(MainViewModel::class.java)
//        enableEdgeToEdge()

        setContent {
            PampiwayTheme {
                Navigation()
                DialogBox()
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

@Composable
fun DialogBox(){
    if (MyComponents.mainViewModel.isDialogShown){
        Add_DeviceDialog(
            onDismiss = {MyComponents.mainViewModel.hideDialog()},
            onAddAddress = { newAdress ->
                MyComponents.mainViewModel.saveAddress(newAdress)
            }
        )
    }
}
