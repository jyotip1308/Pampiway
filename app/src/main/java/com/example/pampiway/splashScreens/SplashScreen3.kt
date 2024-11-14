package com.example.pampiway.splashScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pampiway.R
import com.example.pampiway.utility.SPLASHSCREEN2
import com.example.pampiway.utility.WELCOMESCREEN
import com.example.pampiway.utility.robot_regular
import kotlinx.coroutines.delay

//@Preview
@Composable
fun SplashScreen3(
    navController: NavController
){

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(WELCOMESCREEN)
    }

  Column(modifier = Modifier.fillMaxSize()
      .background(color = Color.White),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally)
  {
      Image(painter = painterResource(R.drawable.pampi_logo),
          contentDescription = "Logo",
          modifier = Modifier.size(160.dp)
      )

      Text(text = "“Everything At Your Doorstep”",
          fontSize = 20.sp,
          fontFamily = robot_regular,
          fontWeight = FontWeight.SemiBold,
          modifier = Modifier.fillMaxWidth(),
          textAlign = TextAlign.Center
      )
  }
}