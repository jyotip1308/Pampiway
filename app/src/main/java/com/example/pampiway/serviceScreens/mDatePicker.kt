package com.example.pampiway.serviceScreens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.pampiway.ui.theme.lightBlack
import com.example.pampiway.ui.theme.mred
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MDatePicker(){

}

@Preview
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePickerDemo() {
    val context = LocalContext.current

    // State to hold the selected date
    var selectedDate by remember { mutableStateOf("") }

    var pickedDate by remember { mutableStateOf(LocalDate.now()) }
    val formattedDate by remember{ derivedStateOf {
        DateTimeFormatter.ofPattern("MMM dd, yyyy").format(pickedDate)
    } }
    val dateDialogState = rememberMaterialDialogState()

                MaterialDialog(
                    dialogState = dateDialogState,
                    properties = DialogProperties(
                        dismissOnClickOutside = true,
                        dismissOnBackPress = true
                    ),
                    onCloseRequest = { /* Handle close request */ },
                    buttons = {
                        positiveButton(text = "Ok", textStyle = TextStyle(color = Color.Red)) {
                            Log.d("DATE", pickedDate.toString())
                        }
                        negativeButton(text = "Cancel", textStyle = TextStyle(color = Color.Red)) { }
                    }
                ) {
                    // Custom Header with increased height
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Custom Header with adjusted height
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp) // Adjust the header height here
                                .background(mred), // Header background color
                            contentAlignment = Alignment.Center
                        ) {

                        }

                        // Date Picker
                        datepicker(
                            initialDate = LocalDate.now(),
                            title = "Select Date",
                            colors = DatePickerDefaults.colors(
                                headerBackgroundColor = mred,
                                headerTextColor = Color.White,
                                dateActiveBackgroundColor = mred,
                                dateInactiveBackgroundColor = Color.White,
                                dateInactiveTextColor = lightBlack,

                                )
                        ) {
                            pickedDate = it
                        }
                    }
                }



  /*  MaterialDialog(
        dialogState = dateDialogState,
        properties = DialogProperties(
            dismissOnClickOutside = true,
            dismissOnBackPress = true,

        ),
        onCloseRequest = {

        },
        buttons = {
            positiveButton(text = "Ok", textStyle = TextStyle(color = mred)){
                showLogs("DATE",pickedDate.toString())
            }
            negativeButton(text = "Cancel", textStyle = TextStyle(color = mred)){

            }
        }
    ) {
            datepicker(
                initialDate = LocalDate.now(),
                title = "Select Date",
                colors = DatePickerDefaults.colors(
                    headerBackgroundColor = mred,
                    headerTextColor = Color.White,
                    dateActiveBackgroundColor = mred,
                    dateInactiveBackgroundColor = Color.White,
                    dateInactiveTextColor = lightBlack,

                )
            ){
                pickedDate = it
            }
    }*/
    // Function to show the DatePicker
    /*fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                selectedDate = "$dayOfMonth/${month + 1}/$year" // Format the selected date
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display selected date
        Text(text = if (selectedDate.isEmpty()) "No Date Selected" else "Selected Date: $selectedDate")

        Spacer(modifier = Modifier.height(16.dp))

        // Button to open the DatePicker
        Button(onClick = { dateDialogState.show()
        }) {
            Text(text = "Select Date")
        }
    }
}


