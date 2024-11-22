package com.example.pampiway.navigationScreen

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pampiway.R
import com.example.pampiway.utility.booking
import com.example.pampiway.utility.food
import com.example.pampiway.utility.home
import com.example.pampiway.utility.mart
import com.example.pampiway.utility.service

// Bottom Navigation Bar
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(home, food, mart, service, booking)

    BottomNavigation (
        backgroundColor = Color.White,
    ){
        items.forEach { screen ->
            BottomNavigationItem(

                icon = {
                    when (screen) {
                        home -> Icon(Icons.Default.Home, contentDescription = "Home")
                        food -> Icon(painter = painterResource(R.drawable.food),
                            modifier = Modifier.size(20.dp),
                            contentDescription = "Food")
                        "mart" -> Icon(painter = painterResource(R.drawable.mart),
                            modifier = Modifier.size(20.dp),
                            contentDescription = "Mart")
                        "service" -> Icon(painter = painterResource(R.drawable.service),
                            modifier = Modifier.size(20.dp),
                            contentDescription = "Service")
                        "booking" -> Icon(painter = painterResource(R.drawable.booking),
                            modifier = Modifier.size(20.dp),
                            contentDescription = "Booking"
                        )
                    }
                },
                label = {
                    Text(screen.replaceFirstChar { it.uppercase() })
                },
                selected = navController.currentBackStackEntry?.destination?.route == screen,
                onClick = {
                    navController.navigate(screen) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selectedContentColor = Color.Red, // Red for selected items
                unselectedContentColor = Color.Black // Black for unselected items
            )
        }
    }
}