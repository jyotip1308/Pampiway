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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_medium

//@Preview
@Composable
fun MenuCard(imageResId: Int, name: String) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Image(painter = painterResource(imageResId),
                contentDescription = "Food1",
//                modifier = Modifier.fillMaxSize(), // Fills the entire Box
//                contentScale = ContentScale.Crop // Crops the image to fit the Box
            )

            Text(text = name,
                fontSize = 13.sp,
                fontFamily = firaSans_regular,
                color = Color.Black,
            )


    }
}