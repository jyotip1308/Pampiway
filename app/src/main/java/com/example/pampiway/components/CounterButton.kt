package com.example.pampiway.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CounterButton(
    count: Int,
    onCountChange: (Int) -> Unit,
    minCount: Int = 0,
    maxCount: Int = Int.MAX_VALUE
) {
    Row(
        modifier = Modifier
            .background(Color.Red, RoundedCornerShape(8.dp)) // Red background with rounded corners
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = {
                if (count > minCount) onCountChange(count - 1) // Decrease count
            },
            modifier = Modifier.size(24.dp)
        ) {
            Text(
                text = "-",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.h6
            )
        }

        Spacer(modifier = Modifier.width(16.dp)) // Space between buttons and text

        Text(
            text = "$count",
            color = Color.White,
            fontSize = 14.sp,
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.width(16.dp)) // Space between buttons and text

        IconButton(
            onClick = {
                if (count < maxCount) onCountChange(count + 1) // Increase count
            },
            modifier = Modifier.size(24.dp)
        ) {
            Text(
                text = "+",
                color = Color.White,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

