package com.example.pampiway.authenticationScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.pampiway.components.RedBorderButton
import com.example.pampiway.components.RedButton
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.utility.SIGNINSCREEN
import com.example.pampiway.utility.firasans_medium

//@Preview
@Composable
fun Welcome(
    navController: NavController
){
    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(R.drawable.rectangle),
            contentDescription = "Rectangle",
            modifier = Modifier.size(350.dp)
        )

        Text(text = "Welcome!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = firasans_medium
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Here is the complete nearby market  in \n your phone. Enjoy the services.",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = grey,
            fontFamily = firasans_medium
        )

        Spacer(modifier = Modifier.height(64.dp))

        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)){

            RedButton("Get Started", buttonHeight = 35.dp) {
                navController.navigate(SIGNINSCREEN)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {

            RedBorderButton("I have already an account", buttonHeight = 35.dp) {

            }
        }
    }
}