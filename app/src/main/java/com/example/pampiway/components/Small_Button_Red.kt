package com.example.pampiway.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.firaSans_regular

@Composable
fun Small_Button_Red(
    buttonText: String,
    modifier: Modifier,
    onClick: () -> Unit

){
    Box(
        modifier = Modifier
            .height(height = 30.dp)
            .width(70.dp)
            .border(width = 1.dp, color = red, shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
    ) {
        androidx.compose.material3.Button(
            onClick = { onClick() },
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
            androidx.compose.material3.Text(
                text = AnnotatedString(buttonText),
                style = TextStyle(
                    color = red,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firaSans_regular,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}