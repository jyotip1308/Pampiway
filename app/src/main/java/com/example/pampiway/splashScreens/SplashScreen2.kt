package com.example.pampiway.splashScreens

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pampiway.R
import com.example.pampiway.ui.theme.darkPink
import com.example.pampiway.ui.theme.lightPink

@Preview
@Composable
fun ExpandingCircleScreen() {
    // Define colors for the circles
    val outerCircleColor = darkPink
    val innerCircleColor = lightPink

    // Define initial and target sizes for the animation
    val targetOuterSize = 900.dp
    val targetInnerSize = 600.dp

    // MutableState to control the animation target
    var outerCircleSizeTarget by remember { mutableStateOf(0.dp) }
    var innerCircleSizeTarget by remember { mutableStateOf(0.dp) }

    // Animate the size of the outer circle
    val outerCircleSize by animateDpAsState(
        targetValue = outerCircleSizeTarget,
        animationSpec = tween(durationMillis = 8000, easing = LinearOutSlowInEasing), label = ""
    )

    // Animate the size of the inner circle
    val innerCircleSize by animateDpAsState(
        targetValue = innerCircleSizeTarget,
        animationSpec = tween(durationMillis = 9000, easing = LinearOutSlowInEasing), label = ""
    )

    // Launch separate animations
    LaunchedEffect(Unit) {
        // Delay to ensure initial state, then animate the outer circle
//        delay(100)
        outerCircleSizeTarget = targetOuterSize
        innerCircleSizeTarget = targetInnerSize
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        // Outer expanding circle
        Box(
            modifier = Modifier
                .size(outerCircleSize)
                .background(color = outerCircleColor, shape = CircleShape)
        )

        // Inner expanding circle
        Box(
            modifier = Modifier
                .size(innerCircleSize)
                .background(color = innerCircleColor, shape = CircleShape)
        )

        // Static white circle behind the logo
        Box(
            modifier = Modifier
                .size(160.dp) // Adjust size as needed to fit around the logo
                .background(color = Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            // Center logo image
            Image(
                painter = painterResource(id = R.drawable.pampi_logo), // Replace with your actual logo resource
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(120.dp)
            )
        }
    }
}
