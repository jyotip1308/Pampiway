package com.example.pampiway.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pampiway.R
import com.example.pampiway.components.Add_DeviceDialog
import com.example.pampiway.components.RedButton
import com.example.pampiway.components.TopNavigationBar
import com.example.pampiway.ui.theme.blue
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.home
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

    Scaffold(
        topBar = {
            TopNavigationBar(
                title = "Search for location",
                onBackClick = { }
            )
        }
    ) { it ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp, top = 28.dp)
        ) {

            Spacer(modifier = Modifier.height(72.dp))

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

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

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
                        MyComponents.mainViewModel.showDialog()
                    },
                    colors = ButtonDefaults.buttonColors(blue),
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

            LazyColumn {
                items(MyComponents.mainViewModel.savedAddresses){ address ->
                    SavedAddressItem(name = address, iconRes = R.drawable.location)
                }
            }


            Spacer(modifier = Modifier.height(36.dp))


            Column(modifier = Modifier.fillMaxHeight(0.3f),
                verticalArrangement = Arrangement.Bottom){

                RedButton("Dashboard", buttonHeight = 40.dp) {

                    navController.navigate(home)
                }
            }

        }
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
            tint = Color.Unspecified,
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
