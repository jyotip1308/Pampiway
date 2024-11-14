package com.example.pampiway.navigationScreen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pampiway.authenticationScreens.SignIn
import com.example.pampiway.authenticationScreens.Verification
import com.example.pampiway.authenticationScreens.Welcome
import com.example.pampiway.location.Location
import com.example.pampiway.splashScreens.ExpandingCircleScreen
import com.example.pampiway.splashScreens.SplashScreen1
import com.example.pampiway.splashScreens.SplashScreen3
import com.example.pampiway.utility.LOCATION
import com.example.pampiway.utility.SIGNINSCREEN
import com.example.pampiway.utility.SPLASHSCREEN1
import com.example.pampiway.utility.SPLASHSCREEN2
import com.example.pampiway.utility.SPLASHSCREEN3
import com.example.pampiway.utility.VERIFICATION
import com.example.pampiway.utility.WELCOMESCREEN

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = VERIFICATION)
    {
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
            Location(navController)
        }
    }
}