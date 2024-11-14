package com.example.pampiway.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.firaSans_regular

//@Preview
@Composable
fun RedButton(
    buttonText: String,
    buttonHeight: Dp = 45.dp,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(width = 300.dp, height = buttonHeight)
            .clickable(onClick = onClick)
            .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp))
    ) {
        Button(
            onClick = { onClick() },
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .matchParentSize()
                .padding(0.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = red
            ),
            elevation = ButtonDefaults.buttonElevation(0.dp)
        ) {
            Text(
                text = AnnotatedString(buttonText),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firaSans_regular,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

//@Preview
@Composable
fun RedBorderButton(
    buttonText: String,
    buttonHeight: Dp = 45.dp,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .height(height = buttonHeight)
            .fillMaxWidth()
            .border(width = 2.dp, color = red, shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp))
    ) {
        Button(
            onClick = { onClick() },
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .matchParentSize()
                .padding(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = red
            ),
            elevation = ButtonDefaults.buttonElevation(0.dp)
        ) {
            Text(
                text = AnnotatedString(buttonText),
                style = TextStyle(
                    color = red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firaSans_regular,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}