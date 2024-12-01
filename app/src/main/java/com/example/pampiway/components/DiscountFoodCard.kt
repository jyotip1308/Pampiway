package com.example.pampiway.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.ui.theme.green
import com.example.pampiway.ui.theme.red
import com.example.pampiway.ui.theme.textGrey
import com.example.pampiway.utility.DiscountMenu
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_medium

//@Preview
@Composable
fun DiscountFoodCard(
    discountMenu: DiscountMenu
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
                text = discountMenu.name,
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = firasans_medium
            )

            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                repeat(discountMenu.rating) {
                    RatingStars(R.drawable.star)
                }
                repeat(5 - discountMenu.rating) {
                    RatingStars(R.drawable.starg)
                }

                Text(
                    text = " ${discountMenu.ratingsCount} ratings",
                    fontSize = 13.sp,
                    fontFamily = firaSans_regular,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Row (verticalAlignment = Alignment.CenterVertically){

                Text(
                text = "₹${discountMenu.originalPrice}",
                    fontSize = 13.sp,
                    fontFamily = firaSans_regular,
                    color = textGrey,
                    textDecoration = TextDecoration.LineThrough
                )
                Text(
                    text = "  ₹${discountMenu.discountPrice}",
                    fontSize = 13.sp,
                    fontFamily = firaSans_regular,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = painterResource(id = R.drawable.down_arrow),
                    contentDescription = "Arrow",
                    modifier = Modifier.size(12.dp),
                    tint = green
                )

                Text(
//
                    text = " ${discountMenu.discountPercent}",
                    fontSize = 13.sp,
                    fontFamily = firaSans_regular,
                    color = green
                )

            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = discountMenu.description,
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
                painter = painterResource(discountMenu.imageResId),
                contentDescription = "Food Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Small_Button_Red(
                "ADD",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 20.dp),
//                onClick = onAddClick
                onClick = {}
            )
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
    DottedDivider(
        color = red,
        dotRadius = 1.dp,
        spacing = 4.dp
    )

    Spacer(modifier = Modifier.height(8.dp))

}

@Composable
fun RatingStars(imageResId: Int) {
    Icon(
        painter = painterResource(imageResId),
        modifier = Modifier.size(10.dp),
        tint = Color.Unspecified,
        contentDescription = "Star Icon"
    )
}