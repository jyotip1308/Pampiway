package com.example.pampiway.navigationScreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pampiway.authenticationScreens.SignIn
import com.example.pampiway.authenticationScreens.SignUpScreen
import com.example.pampiway.authenticationScreens.Verification
import com.example.pampiway.authenticationScreens.VerifyDetails
import com.example.pampiway.authenticationScreens.Welcome
import com.example.pampiway.location.CurrentLocation
import com.example.pampiway.location.ManualLocation
import com.example.pampiway.mainScreens.BookingScreen
import com.example.pampiway.mainScreens.FoodScreen
import com.example.pampiway.mainScreens.MartScreen
import com.example.pampiway.mainScreens.ProductHomeScreen
import com.example.pampiway.mainScreens.ServiceScreen
import com.example.pampiway.splashScreens.ExpandingCircleScreen
import com.example.pampiway.splashScreens.SplashScreen1
import com.example.pampiway.splashScreens.SplashScreen3
import com.example.pampiway.utility.LOCATION
import com.example.pampiway.utility.MANUALLOCATION
import com.example.pampiway.utility.MyComponents.navController
import com.example.pampiway.utility.SIGNINSCREEN
import com.example.pampiway.utility.SIGNUP
import com.example.pampiway.utility.SPLASHSCREEN1
import com.example.pampiway.utility.SPLASHSCREEN2
import com.example.pampiway.utility.SPLASHSCREEN3
import com.example.pampiway.utility.VERIFICATION
import com.example.pampiway.utility.VERIFYDETAILS
import com.example.pampiway.utility.WELCOMESCREEN
import com.example.pampiway.utility.booking
import com.example.pampiway.utility.food
import com.example.pampiway.utility.home
import com.example.pampiway.utility.mart
import com.example.pampiway.utility.service

@Composable
fun Navigation() {
    navController = rememberNavController()

    Scaffold(
        bottomBar = {
            // Show BottomNavigationBar only on the specific screens
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentRoute in listOf(home, food, mart, service, booking)) {
                BottomNavigationBar(navController)
            }
        },

    ) { it ->

        NavHost(navController, startDestination = WELCOMESCREEN) {
            composable(SPLASHSCREEN1) {
                SplashScreen1(navController)
            }

            composable(SPLASHSCREEN2) {
                ExpandingCircleScreen(navController)
            }

            composable(SPLASHSCREEN3) {
                SplashScreen3(navController)
            }

            composable(WELCOMESCREEN) {
                Welcome(navController)
            }

            composable(SIGNINSCREEN) {
                SignIn(navController)
            }

            composable(VERIFICATION) {
                Verification(navController)
            }

            composable(LOCATION) {
                CurrentLocation(navController)
            }

            composable(MANUALLOCATION) {
                ManualLocation(navController)
            }

            composable(SIGNUP) {
                SignUpScreen(navController)
            }

            composable(VERIFYDETAILS) {
                VerifyDetails(navController)
            }

            composable(home) {
                ProductHomeScreen(navController)
            }

            composable(food) {
                FoodScreen(navController)
            }

            composable(mart) {
                MartScreen(navController)
            }
            composable(service) {
                ServiceScreen(navController)
            }
            composable(booking) {
                BookingScreen(navController)
            }
        }
    }
}