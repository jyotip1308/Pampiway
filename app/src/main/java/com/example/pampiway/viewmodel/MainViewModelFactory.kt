package com.example.pampiway.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pampiway.repository.AuthRepo

class MainViewModelFactory(private val authRepo: AuthRepo, private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(authRepo,context) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
