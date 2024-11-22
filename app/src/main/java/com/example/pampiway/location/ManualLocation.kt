package com.example.pampiway.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pampiway.R
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.DIALOGBOX
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch

//@Preview
@Composable
fun ManualLocation(
    navController: NavController,
    fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(LocalContext.current),
    onCurrentLocationClicked: () -> Unit = {}
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // State for search text
    var searchText by remember { mutableStateOf("") }

    // State for permission
    var permissionGranted by remember { mutableStateOf(false) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted -> permissionGranted = granted }
    )

    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp, top = 28.dp)
    ) {
        // Back button and title
        Row(modifier = Modifier.padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* handle back press */ }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Search for location",
                fontSize = 20.sp,
                color = Color.Black,
                fontFamily = firasans_bold,
                fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Search bar
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text("e.g. mela ka choraya") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_24),
                    contentDescription = "Search Icon",
                    tint = red
                )
            },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Use current location button

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        if (permissionGranted) {
                            coroutineScope.launch {
                                getLastLocation(fusedLocationClient, context) { location ->
                                    // Handle current location result here
                                    onCurrentLocationClicked()
                                }
                            }
                        } else {
                            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                        }
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.current_location),
                    contentDescription = "Current Location Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "use current location",
                    color = red,
                    fontWeight = FontWeight.Medium
                )
            }

            // Blue "Add Location" button
            Button(
                onClick = {
                   navController.navigate(DIALOGBOX)
                },
                colors = ButtonDefaults.buttonColors(Color.Blue),
            ) {
                Text(
                    text = "Add Location",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontFamily = firaSans_regular,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Divider(color = Color.Gray, thickness = 0.9.dp)

        Spacer(modifier = Modifier.height(16.dp))

        // Saved addresses section
        Text(
            text = "Saved address",
            fontSize = 16.sp,
            color = grey,
            fontFamily = firaSans_regular,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Example saved addresses
        SavedAddressItem(name = "Bus stand rajgarh", iconRes = R.drawable.flag_india)
        SavedAddressItem(name = "sanju home rajgarh", iconRes = R.drawable.flag_india)
    }
}

@Composable
fun SavedAddressItem(name: String, iconRes: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* Navigate to address location or select */ }
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = name,
//            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = name, fontSize = 16.sp, color = Color.Black)
    }
}

@SuppressLint("MissingPermission")
private suspend fun getLastLocation(
    fusedLocationClient: FusedLocationProviderClient,
    context: Context,
    onLocationRetrieved: (Location?) -> Unit
) {
    fusedLocationClient.lastLocation
        .addOnSuccessListener { location ->
            onLocationRetrieved(location)
        }
        .addOnFailureListener {
            onLocationRetrieved(null)
        }
    }
