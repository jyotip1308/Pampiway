package com.example.pampiway.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.ui.theme.darkGrey
import com.example.pampiway.ui.theme.mred
import com.example.pampiway.utility.firasans_medium

@Composable
fun SmallButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 5.dp,
    backgroundColor: Color = mred,
    contentColor: Color = Color.White,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(0.dp),

        modifier = modifier
            .fillMaxWidth().height(45.dp)
    ) {
        Text(text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = firasans_medium,
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 8.dp))
    }
}

@Composable
fun SmallButtonBorder(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 5.dp,
    backgroundColor: Color = Color.White, // Transparent background for border effect
    borderColor: Color = mred, // Border color
    contentColor: Color = mred, // Content color
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.padding(bottom = 16.dp)
            .fillMaxWidth()
            .height(45.dp)
            .border(
                BorderStroke(2.dp, borderColor), // Add border with specified color
                shape = RoundedCornerShape(cornerRadius)
            )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = firasans_medium,
            color = contentColor, // Match text color with contentColor
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
    }
}



@Composable
fun SmallButtonRounded(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 5.dp,
    backgroundColor: Color = mred,
    contentColor: Color = Color.White,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(0.dp),

        modifier = modifier
            .fillMaxWidth(0.65f).height(45.dp)
    ) {
        Text(text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = firasans_medium,
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 8.dp))
    }
}

@Composable
fun SmallButtonBorderRounded(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 5.dp,
    backgroundColor: Color = Color.White, // Transparent background for border effect
    borderColor: Color = mred, // Border color
    contentColor: Color = darkGrey, // Content color
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.padding(bottom = 16.dp)
            .fillMaxWidth(0.7f)
            .height(45.dp)
            .border(
                BorderStroke(1.5.dp, borderColor), // Add border with specified color
                shape = RoundedCornerShape(cornerRadius)
            )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = firasans_medium,
            color = contentColor, // Match text color with contentColor
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
    }
}
