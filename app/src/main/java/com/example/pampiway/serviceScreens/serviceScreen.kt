package com.example.pampiway.serviceScreens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.components.DefaultHorizontalViewPagerWithDots
import com.example.pampiway.components.SmallButton
import com.example.pampiway.ui.theme.darkGrey
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.lightBlack
import com.example.pampiway.ui.theme.mred
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium

@Preview
@Composable
fun serviceScreen() {

    val shopName = remember {
        mutableStateOf("Shree Ram Travels")
    }
    val name = remember {
        mutableStateOf("Shree Ram Travels")
    }
    val address = remember {
        mutableStateOf("Shree Ram Travels")
    }
    val aboutus = remember {
        mutableStateOf("Shree Ram Travels")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(vertical = 16.dp, horizontal = 12.dp), verticalArrangement = Arrangement.SpaceBetween
    ) {
        
        Column() {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {

                Text(
                    text = shopName.value,
                    style = TextStyle(
                        fontFamily = firasans_bold,
                        fontWeight = FontWeight.Bold,
                        color = lightBlack,
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(start = 32.dp)
                        .fillMaxWidth(0.9f)
                )

                Image(
                    painterResource(id = R.drawable.ic_optiondot),
                    contentDescription = "dots",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            MyComponents.navController.popBackStack()
                        },
                    contentScale = ContentScale.Fit
                )
            }
            Divider(
                color = Color.White,              // Set the color of the divider
                thickness = 4.dp,                // Set the thickness of the divider
                modifier = Modifier.fillMaxWidth() // Make the divider take full width
            )
            Spacer(modifier = Modifier.height(4.dp))
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Service",
                    style = TextStyle(
                        fontFamily = firaSans_regular,
                        fontWeight = FontWeight.Normal,
                        color = darkGrey,
                        fontSize = 14.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(4.dp))
                Canvas(modifier = Modifier.fillMaxWidth(0.2f)) {
                    val lineWidth = size.width
                    val dashWidth = 2.dp.toPx()
                    val gapWidth = 1.dp.toPx()

                    var x = 0f
                    while (x < lineWidth) {
                        drawLine(
//                            color = medGrey,
                            color = grey,
                            start = Offset(x, 0f),
                            end = Offset(x + dashWidth, 0f),
                            strokeWidth = 2.dp.toPx()
                        )
                        x += dashWidth + gapWidth
                    }
                }
            }

            DefaultHorizontalViewPagerWithDots()

            DetailsService(name.value,address.value,aboutus.value)

            
            
        }
        
        SmallButton(onClick = {

        }, text =  "Call")
        

    }

}


@Composable fun DetailsService(name:String, address:String, about:String){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
        Text(
            text = "Owner:-",
            style = TextStyle(
                fontFamily = firasans_medium,
                fontWeight = FontWeight.SemiBold,
                color = mred,
                fontSize = 14.sp
            ), modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = name,
            style = TextStyle(
                fontFamily = firasans_medium,
                fontWeight = FontWeight.Medium,
                color = lightBlack,
                fontSize = 13.sp
            ), modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Address:-",
            style = TextStyle(
                fontFamily = firasans_medium,
                fontWeight = FontWeight.SemiBold,
                color = mred,
                fontSize = 14.sp
            ), modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = address,
            style = TextStyle(
                fontFamily = firasans_medium,
                fontWeight = FontWeight.Medium,
                color = lightBlack,
                fontSize = 13.sp
            ), modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "About Us:-",
            style = TextStyle(
                fontFamily = firasans_medium,
                fontWeight = FontWeight.SemiBold,
                color = mred,
                fontSize = 14.sp
            ), modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = about,
            style = TextStyle(
                fontFamily = firasans_medium,
                fontWeight = FontWeight.Medium,
                color = lightBlack,
                fontSize = 13.sp
            ), modifier = Modifier
                .fillMaxWidth()
        )
    }
}