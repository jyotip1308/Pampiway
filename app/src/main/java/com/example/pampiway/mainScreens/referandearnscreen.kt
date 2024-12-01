package com.example.pampiway.mainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.components.SmallButtonBorderRounded
import com.example.pampiway.components.SmallButtonRounded
import com.example.pampiway.ui.theme.darkGrey
import com.example.pampiway.ui.theme.lightBlack
import com.example.pampiway.ui.theme.mred
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_medium

@Composable
fun ReferAndEarnScreen() {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        val couponcode by remember {
            mutableStateOf("2X9AJGME39C4")
        }
        // This Column handles the content and the button separately.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // Enable vertical scrolling
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween // Ensures bottom alignment
        ) {
            // Top content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(vertical = 16.dp)
            ){
                Image(
                    painterResource(id = R.drawable.ic_referearn),
                    contentDescription = "image",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .padding(24.dp),
                    contentScale = ContentScale.Fit)

                Text(text = "Earn 150 Coins!",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontFamily = firasans_medium,
                        fontSize = 24.sp,
                        color = mred, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                )

                Text(text = "For every new user you refer",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontFamily = firasans_medium,
                        fontSize = 18.sp,
                        color = lightBlack, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                )

                Text(text = "share your referral link and \n" +
                        "earn 150 coins",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontFamily = firaSans_regular,
                        fontSize = 16.sp,
                        color = darkGrey, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(top = 4.dp)
                        .fillMaxWidth()
                )

            }


            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                // Bottom button
                SmallButtonBorderRounded(onClick = {

                }, text = couponcode, cornerRadius = 60.dp)

                Spacer(modifier = Modifier.padding(bottom = 12.dp))

                SmallButtonRounded(onClick = {

                }, text = "Share", cornerRadius = 60.dp)

                Spacer(modifier = Modifier.padding(bottom = 48.dp))

            }
        }
    }
}
