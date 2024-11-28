package com.example.pampiway.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.pampiway.R
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_medium

@Composable
fun FoodCard(
    foodName: String,
    price: String,
    rating: Int,
    ratingsCount: String,
    description: String,
    imageResId: Int,
    onAddClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Food details column
        Column {
            Text(
                text = foodName,
                fontSize = 18.sp,
                color = Color.Black,
                fontFamily = firasans_medium
            )

            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                repeat(rating) {
                    Stars(R.drawable.star)
                }
                repeat(5 - rating) {
                    Stars(R.drawable.starg)
                }

                Text(
                    text = " $ratingsCount ratings",
                    fontSize = 13.sp,
                    fontFamily = firaSans_regular,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "₹$price",
                fontSize = 13.sp,
                fontFamily = firaSans_regular,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = description,
                fontSize = 13.sp,
                fontFamily = firaSans_regular,
                color = Color.Black
            )
        }

        // Image and Add Button
        Box(
            modifier = Modifier
                .size(height = 150.dp, width = 170.dp)
                .padding(12.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(imageResId),
                contentDescription = "Food Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Small_Button_Red(
                "ADD",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 20.dp),
                onClick = onAddClick
            )
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
    DottedDivider(
        color = red,
        dotRadius = 1.dp,
        spacing = 4.dp
    )
}

@Composable
fun Stars(imageResId: Int) {
    Icon(
        painter = painterResource(imageResId),
        modifier = Modifier.size(10.dp),
        tint = Color.Unspecified,
        contentDescription = "Star Icon"
    )
}
