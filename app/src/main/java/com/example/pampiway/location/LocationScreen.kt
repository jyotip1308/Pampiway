package com.example.pampiway.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.Geocoder
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pampiway.R
import com.example.pampiway.components.RedButton
import com.example.pampiway.components.RedBorderButton
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.utility.MANUALLOCATION
import com.example.pampiway.utility.firasans_medium
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch
import java.util.Locale


// Complete Location Name

@Composable
fun CurrentLocation(navController: NavController) {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    val coroutineScope = rememberCoroutineScope()

    // Permission state
    var permissionGranted by remember { mutableStateOf(false) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted -> permissionGranted = granted }
    )

    // Area information state
    var locality by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        // Request permission on start
        launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.location),
            contentDescription = "Location Icon",
            modifier = Modifier.size(width = 280.dp, height = 350.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Grant location",
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontFamily = firasans_medium
        )

        Spacer(modifier = Modifier.height(14.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp)
        ) {
            Text(
                text = "This lets us show nearby restaurants \n stores you can order from",
                fontSize = 14.sp,
                color = grey,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Display the location details
            Text(
                text = "Location Details:",
                fontSize = 18.sp,
                color = grey,
                fontFamily = firasans_medium,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            val styledText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firasans_medium, fontSize = 14.sp)
                ) {
                    append("Locality: $locality,  ")
                }
                withStyle(style = SpanStyle(color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firasans_medium, fontSize = 14.sp)
                ) {
                    append("Postal Code: $postalCode,  ")

                }

                withStyle(style = SpanStyle(color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firasans_medium, fontSize = 14.sp)
                ) {
                    append("State: $state")

                }
            }

            // Display the styled text in a Text composable
            Text(text = styledText)


            Spacer(modifier = Modifier.height(46.dp))

            RedButton("Current Location", buttonHeight = 45.dp) {
                if (permissionGranted) {
                    coroutineScope.launch {
                        getLastLocation(fusedLocationClient, context) {loc, ct, postal ->
                            locality = loc
                            state = ct
                            postalCode = postal
                        }
                    }
                } else {
                    launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            RedBorderButton("Enter Manually", buttonHeight = 45.dp) {
                navController.navigate(MANUALLOCATION)
            }
        }
    }
}

@SuppressLint("MissingPermission")
private suspend fun getLastLocation(
    fusedLocationClient: FusedLocationProviderClient,
    context: Context,
    onLocationRetrieved: (String, String, String) -> Unit
) {
    fusedLocationClient.lastLocation
        .addOnSuccessListener { location: Location? ->
            if (location != null) {
                // Reverse geocode to get detailed address
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)

                if (!addresses.isNullOrEmpty()) {
                    val address = addresses[0]
                    val loc = address.locality ?: "Unknown locality"
                    val ct = address.adminArea ?: "Unknown city"
                    val postal = address.postalCode ?: "Unknown postal code"

                    onLocationRetrieved(loc, ct, postal)
                    Log.d("Location", "Latitude: ${location.latitude}, Longitude: ${location.longitude}, Locality: $loc, City: $ct, Postal Code: $postal")
                } else {
                    onLocationRetrieved("Address not available", "", "")
                    Log.d("Location", "Address not available")
                }
            } else {
                onLocationRetrieved("Location not available", "", "")
                Log.d("Location", "Location not available")
            }
        }
        .addOnFailureListener {
            onLocationRetrieved("Failed to get location", "", "")
            Log.e("Location", "Failed to get location", it)
        }
}



// Just Area Name
/*
@Composable
fun Location(navController: NavController) {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    val coroutineScope = rememberCoroutineScope()

    // Permission state
    var permissionGranted by remember { mutableStateOf(false) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted -> permissionGranted = granted }
    )

    // Area name state
    var areaName by remember { mutableStateOf("Unknown location") }

    LaunchedEffect(Unit) {
        // Request permission on start
        launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.location),
            contentDescription = "Rectangle",
            modifier = Modifier.size(350.dp)
        )

        Text(
            text = "Grant location",
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontFamily = firasans_medium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp)
        ) {
            Text(
                text = "This lets us show nearby restaurants and stores you can order from",
                fontSize = 13.sp,
                color = grey,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(64.dp))

            // Display the area name
            Text(
                text = "Area: $areaName",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            RedButton("Current Location", buttonHeight = 45.dp) {
                if (permissionGranted) {
                    coroutineScope.launch {
                        getLastLocation(fusedLocationClient, context) { area ->
                            areaName = area
                        }
                    }
                } else {
                    launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            RedBorderButton("Enter Manually", buttonHeight = 45.dp) {
                // Action for manually entering the location
            }
        }
    }
}

@SuppressLint("MissingPermission")
private suspend fun getLastLocation(
    fusedLocationClient: FusedLocationProviderClient,
    context: Context,
    onAreaRetrieved: (String) -> Unit
) {
    fusedLocationClient.lastLocation
        .addOnSuccessListener { location: Location? ->
            if (location != null) {
                // Reverse geocode to get area name
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                val area = addresses?.firstOrNull()?.locality ?: "Unknown location"
                onAreaRetrieved(area)
                Log.d("Location", "Latitude: ${location.latitude}, Longitude: ${location.longitude}, Area: $area")
            } else {
                onAreaRetrieved("Location not available")
                Log.d("Location", "Location not available")
            }
        }
        .addOnFailureListener {
            onAreaRetrieved("Failed to get location")
            Log.e("Location", "Failed to get location", it)
        }
}
*/
