package com.example.pampiway.mainScreens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.components.SmallButtonBorder
import com.example.pampiway.ui.theme.darkGrey
import com.example.pampiway.ui.theme.lightBlack
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_medium

@Composable
fun OrderPlaced() {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        val orderID by remember {
            mutableStateOf("#239587394")
        }

        val orderTime by remember {
            mutableStateOf("30 - 35 mins")
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
                    painterResource(id = R.drawable.ic_rateimage),
                    contentDescription = "image",
                    modifier = Modifier.padding(16.dp).fillMaxWidth().padding(24.dp),
                    contentScale = ContentScale.Fit)

                Text(text = "Order Placed!",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontFamily = firasans_medium,
                        fontSize = 24.sp,
                        color = lightBlack
                    ), modifier = Modifier.padding(top = 12.dp)
                )

                //part A
                Text(text = "Order ID",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = firasans_medium,
                        fontSize = 20.sp,
                        color = lightBlack
                    ), modifier = Modifier.padding(top = 12.dp, start = 36.dp)
                )
                Text(text = orderID,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontFamily = firaSans_regular,
                        fontSize = 17.sp,
                        color = darkGrey
                    ), modifier = Modifier.padding(top = 2.dp, start = 36.dp, bottom = 6.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Canvas(modifier = Modifier.fillMaxWidth()) {
                        val lineWidth = size.width
                        val dashWidth = 2.dp.toPx()
                        val gapWidth = 1.dp.toPx()

                        var x = 0f
                        while (x < lineWidth) {
                            drawLine(
                                color = Color.Red,
                                start = Offset(x, 0f),
                                end = Offset(x + dashWidth, 0f),
                                strokeWidth = 2.dp.toPx()
                            )
                            x += dashWidth + gapWidth
                        }
                    }
                }


                //part B
                Text(text = "Delivery Time",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontFamily = firasans_medium,
                        fontSize = 20.sp,
                        color = lightBlack
                    ), modifier = Modifier.padding(top = 12.dp, start = 36.dp)
                )
                Text(text = orderTime,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontFamily = firaSans_regular,
                        fontSize = 17.sp,
                        color = darkGrey
                    ), modifier = Modifier.padding(top = 2.dp, start = 36.dp, bottom = 6.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Canvas(modifier = Modifier.fillMaxWidth()) {
                        val lineWidth = size.width
                        val dashWidth = 2.dp.toPx()
                        val gapWidth = 1.dp.toPx()

                        var x = 0f
                        while (x < lineWidth) {
                            drawLine(
                                color = Color.Red,
                                start = Offset(x, 0f),
                                end = Offset(x + dashWidth, 0f),
                                strokeWidth = 2.dp.toPx()
                            )
                            x += dashWidth + gapWidth
                        }
                    }
                }
            }

            // Bottom button
            SmallButtonBorder(onClick = {

            }, text = "Cancel Order")
        }
    }
}
