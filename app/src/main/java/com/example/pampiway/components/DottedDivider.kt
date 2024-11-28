package com.example.pampiway.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DottedDivider(
    color: Color = Color.Red,
    dotRadius: Dp = 1.dp,
    spacing: Dp = 3.dp,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
) {
    Canvas(modifier = modifier) {
        val dotDiameter = dotRadius.toPx() * 2
        val dotSpacing = spacing.toPx()
        val totalWidth = size.width
        var currentX = 0f

        while (currentX < totalWidth) {
            drawCircle(
                color = color,
                radius = dotRadius.toPx(),
                center = Offset(currentX + dotRadius.toPx(), size.height / 2)
            )
            currentX += dotDiameter + dotSpacing
        }
    }
}