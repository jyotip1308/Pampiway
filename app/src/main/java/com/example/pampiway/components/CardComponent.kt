package com.example.pampiway.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.utility.firasans_medium

//@Preview
@Composable
fun CardComponent(text: String, imageResId: Int, onClick: ()-> Unit) {
    Card(
        modifier = Modifier
            .height(140.dp)
            .width(160.dp)
            .clickable { onClick() },
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
//            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontFamily = firasans_medium,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.width(16.dp)) // Space between image and text

            Spacer(modifier = Modifier.height(24.dp)) // Space between image and text

            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "text",
                modifier = Modifier
                    .size(84.dp)
                    .fillMaxWidth()
                    .align(Alignment.End)
            )
        }
    }
}
