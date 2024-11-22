package com.example.pampiway.mainScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ServiceScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
                .fillMaxSize()
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp, top = 28.dp)
    ) {
        Text(text = "Service",
            color = Color.Black
        )
    }
}