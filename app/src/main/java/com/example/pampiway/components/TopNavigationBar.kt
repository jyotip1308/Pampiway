package com.example.pampiway.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.topGrey
import com.example.pampiway.utility.firasans_medium

@Composable
fun TopNavigationBar(
    title: String,
    onBackClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = topGrey, // Light grey background
        contentPadding = PaddingValues(top = 26.dp, start = 8.dp, end = 16.dp),
        elevation = 4.dp // Slight shadow
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack, // Back arrow icon
                    contentDescription = "Back",
                    tint = Color.Black // Icon color
                )
            }
            Text(
                text = title,
                color = Color.Black, // Text color
                style = MaterialTheme.typography.h6, // Text style
                fontFamily = firasans_medium
            )
        }
    }
}
