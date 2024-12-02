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
import com.example.pampiway.bookingScreens.BookingDashboard
import com.example.pampiway.location.CurrentLocation
import com.example.pampiway.location.ManualLocation
import com.example.pampiway.mainScreens.CartScreen
import com.example.pampiway.mainScreens.EditProfile
import com.example.pampiway.mainScreens.FoodScreen
import com.example.pampiway.mainScreens.HelpSupport
import com.example.pampiway.mainScreens.NotificationUser
import com.example.pampiway.mainScreens.OrderPlaced
import com.example.pampiway.mainScreens.OrderPlacing
import com.example.pampiway.mainScreens.PopularRestaurantsScreen
import com.example.pampiway.mainScreens.ProductHomeScreen
import com.example.pampiway.mainScreens.RatingScreen
import com.example.pampiway.mainScreens.ReferAndEarnScreen
import com.example.pampiway.mainScreens.RestaurantDetailsScreen
import com.example.pampiway.martScreens.AdharMart
import com.example.pampiway.martScreens.MartCartScreen
import com.example.pampiway.martScreens.MartDashboard
import com.example.pampiway.martScreens.ParcelScreen
import com.example.pampiway.martScreens.bookingScreen
import com.example.pampiway.martScreens.carTravelScreen
import com.example.pampiway.martScreens.couponscreen
import com.example.pampiway.serviceScreens.ElectriciansScreen
import com.example.pampiway.serviceScreens.ServiceDashboard
import com.example.pampiway.serviceScreens.serviceScreen
import com.example.pampiway.serviceScreens.shopscreen
import com.example.pampiway.splashScreens.ExpandingCircleScreen
import com.example.pampiway.splashScreens.SplashScreen1
import com.example.pampiway.splashScreens.SplashScreen3
import com.example.pampiway.utility.ADHARMART
import com.example.pampiway.utility.BOOKINGSCREEN
import com.example.pampiway.utility.CART
import com.example.pampiway.utility.CARTRAVELSSCREEN
import com.example.pampiway.utility.COUPONSCREEN
import com.example.pampiway.utility.EDITPROFILE
import com.example.pampiway.utility.ELECTRICIANS
import com.example.pampiway.utility.HELPSUPPORT
import com.example.pampiway.utility.LOCATION
import com.example.pampiway.utility.MANUALLOCATION
import com.example.pampiway.utility.MARTCARTSCREEN
import com.example.pampiway.utility.MyComponents.navController
import com.example.pampiway.utility.NOTIFICATIONUSER
import com.example.pampiway.utility.ORDERPLACEDSCREEN
import com.example.pampiway.utility.ORDERPLACINGSCREEN
import com.example.pampiway.utility.PARCELSCREEN
import com.example.pampiway.utility.POPULARRESTAURANTS
import com.example.pampiway.utility.RATINGSCREEN
import com.example.pampiway.utility.REFERANDEARNSCREEN
import com.example.pampiway.utility.RESTAURANTDETAILSCREEN
import com.example.pampiway.utility.SERVICESCREEN
import com.example.pampiway.utility.SHOPSSCREEN
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

        NavHost(navController, startDestination = food) {
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
                MartDashboard(navController)
            }
            composable(service) {
                ServiceDashboard(navController)
            }
            composable(booking) {
                BookingDashboard(navController)
            }
            composable(CART) {
                CartScreen()
            }
            composable(EDITPROFILE) {
                EditProfile()
            }

            composable(HELPSUPPORT) {
                HelpSupport()
            }

            composable(NOTIFICATIONUSER) {
                NotificationUser(navController)
            }

            composable(ORDERPLACEDSCREEN) {
                OrderPlaced()
            }
            composable(ORDERPLACINGSCREEN) {
                OrderPlacing()
            }
            composable(POPULARRESTAURANTS) {
                PopularRestaurantsScreen()
            }
            composable(RATINGSCREEN) {
                RatingScreen()
            }
            composable(REFERANDEARNSCREEN) {
                ReferAndEarnScreen()
            }
            composable(RESTAURANTDETAILSCREEN) {
                RestaurantDetailsScreen()
            }
            composable(ADHARMART) {
                AdharMart()
            }
            composable(BOOKINGSCREEN) {
                bookingScreen()
            }
            composable(CARTRAVELSSCREEN) {
                carTravelScreen(navController)
            }
            composable(COUPONSCREEN) {
                couponscreen()
            }
            composable(MARTCARTSCREEN) {
                MartCartScreen()
            }
            composable(PARCELSCREEN) {
                ParcelScreen()
            }
            composable(ELECTRICIANS) {
                ElectriciansScreen()
            }
            composable(SERVICESCREEN) {
                serviceScreen()
            }
            composable(SHOPSSCREEN) {
                shopscreen()
            }
        }
    }
}