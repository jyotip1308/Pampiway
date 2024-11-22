package com.example.pampiway.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.pampiway.R
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_medium

@Composable
fun FoodLazyRow() {

    Row(
        modifier = Modifier.fillMaxWidth()
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
            Column {
                Text(
                    text = "Aloo Tikki Burger",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontFamily = firasans_medium,
                )


                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Stars(R.drawable.star)
                    Stars(R.drawable.star)
                    Stars(R.drawable.star)
                    Stars(R.drawable.starg)
                    Stars(R.drawable.starg)
                    Text(
                        text = " 10 ratings",
                        fontSize = 12.sp,
                        fontFamily = firaSans_regular,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "₹180",
                    fontSize = 12.sp,
                    fontFamily = firaSans_regular,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "most selling burger of \n" +
                            "ours with all time favourite\nmost selling burger of \n" +
                            "ours with all time \nfavourite....read more",
                    fontSize = 12.sp,
                    fontFamily = firaSans_regular,
                    color = Color.Black
                )
            }

        Box(
            modifier = Modifier
                .size(150.dp)
        ) {
            Image(painter = painterResource(R.drawable.allu_tikkiburger),
                contentDescription = "Food1",
                modifier = Modifier.fillMaxSize(), // Fills the entire Box
                contentScale = ContentScale.Crop // Crops the image to fit the Box
            )

           Small_Button_Red("ADD") { }

        }

    }
}

@Composable
fun Stars(imageResId: Int){
    Icon(
        painter = painterResource(imageResId),
        modifier = Modifier.size(10.dp),
        tint = Color.Unspecified,
        contentDescription = "Favorite Icon"
    )
}

@Preview
@Composable
fun PreviewFoodLazyRow() {
    FoodLazyRow()
}
