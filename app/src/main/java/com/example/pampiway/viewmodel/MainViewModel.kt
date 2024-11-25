package com.example.pampiway.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pampiway.repository.AuthRepo
import kotlinx.coroutines.launch

class MainViewModel(val authRepo: AuthRepo, context: Context,) : ViewModel() {

    val phone_number = mutableStateOf("")
    val otp = mutableStateOf("")

    var isDialogShown by mutableStateOf(false)
        private set

    fun showDialog(){
        isDialogShown = true
    }

    fun hideDialog (){
        isDialogShown = false
    }

    fun createCustomer(full_name: String, email: String, phone_number: String, dob: String) {
        viewModelScope.launch {
            authRepo.createCustomer(full_name, email, phone_number, dob)
            Log.d("Create Customer", "createCustomer..... ")
        }
    }

    fun login(phone_number: String){
        viewModelScope.launch {
            authRepo.login(phone_number)
            this@MainViewModel.phone_number.value =phone_number
        }
    }

    fun verification(phone_number: String, otp: String){
        viewModelScope.launch {
            authRepo.verification(phone_number, otp)
        }
    }
}