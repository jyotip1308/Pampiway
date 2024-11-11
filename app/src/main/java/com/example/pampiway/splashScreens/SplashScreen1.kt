package com.example.pampiway.splashScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pampiway.ui.theme.red

@Preview
@Composable
fun SplashScreen1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = red),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "EVERYTHINGS AT YOUR \n DOORSET",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 36.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}