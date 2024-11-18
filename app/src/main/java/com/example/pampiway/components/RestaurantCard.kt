package com.example.pampiway.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.utility.firasans_medium

//@Preview
@Composable
fun RestaurantCard(imageResId: Int, name: String, cuisine: String, rating: Double, distance: String, time: String) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp),
    ) {
        Box(
            modifier = Modifier
                .size(116.dp)
                .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(4.dp))
        ) {
            Image(painter = painterResource(imageResId),
                contentDescription = "Food1",
                modifier = Modifier.fillMaxSize(), // Fills the entire Box
                contentScale = ContentScale.Crop // Crops the image to fit the Box
            )

            Icon(Icons.Default.FavoriteBorder,
                modifier = Modifier.align(Alignment.TopEnd),
                tint = grey,
                contentDescription = "Favorite Icon")

        }
        Column(modifier = Modifier/*.weight(1f)*/
            .padding(start = 4.dp)) {
            Text(text = name,
                fontSize = 15.sp,
                fontFamily = firasans_medium,
                color = Color.Black,
                fontWeight = FontWeight.Bold)

            Text(text = cuisine,
                fontSize = 13.sp,
                fontFamily = firasans_medium,
                color = Color.LightGray
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(painter = painterResource(R.drawable.star),
                    contentDescription = "Star",
                    modifier = Modifier.size(10.dp)
                )

                Text(text = " $rating | $distance| $time",
                    fontSize = 13.sp,
                    fontFamily = firasans_medium,
                    color = Color.LightGray
                )
            }
        }
    }
}