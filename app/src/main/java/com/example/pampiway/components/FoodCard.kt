package com.example.pampiway.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.FoodItem

@Composable
fun FoodCard(foodItem: FoodItem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .width(170.dp)
            .height(220.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = foodItem.imageRes),
                contentDescription = foodItem.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = foodItem.title,
                fontSize = 12.sp,
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = foodItem.price,
                    style = MaterialTheme.typography.body1,
                    color = Color.Black,
                    fontSize = 12.sp
                )

                Box(
                    modifier = Modifier
                        .height(height = 39.dp)
                        .width(64.dp)
                        .border(width = 1.dp, color = red, shape = RoundedCornerShape(8.dp))
//                        .clickable(onClick = onClick)
                        .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp))
                ) {
                    androidx.compose.material3.Button(
                        onClick = {/* onClick() */},
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .matchParentSize()
                            .padding(0.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = red
                        ),
                        elevation = androidx.compose.material3.ButtonDefaults.buttonElevation(0.dp)
                    ) {
                        Text(
                            text = "ADD",
                            color = red,
                            fontSize = 12.sp,
                            style = MaterialTheme.typography.button
                        )
                    }
                }
            }
        }
    }
}