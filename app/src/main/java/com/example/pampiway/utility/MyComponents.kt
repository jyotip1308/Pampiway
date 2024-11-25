package com.example.pampiway.utility

import androidx.navigation.NavHostController
import com.example.pampiway.network.AuthAPIs
import com.example.pampiway.repository.AuthRepo
import com.example.pampiway.viewmodel.MainViewModel
import com.example.pampiway.viewmodel.MainViewModelFactory

object MyComponents {
    lateinit var mainViewModel: MainViewModel
    lateinit var mainViewModelFactory: MainViewModelFactory
    lateinit var authAPI: AuthAPIs
    lateinit var authRepo: AuthRepo
    lateinit var navController: NavHostController
}