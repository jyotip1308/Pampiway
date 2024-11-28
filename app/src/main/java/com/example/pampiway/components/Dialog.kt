package com.example.pampiway.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.example.pampiway.ui.theme.blue
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.SIGNUP
import com.example.pampiway.utility.firaSans_regular

@OptIn(ExperimentalMaterialApi::class)

//@Preview
@Composable
fun Add_DeviceDialog(
    onDismiss: () -> Unit,
    onAddAddress: (String) -> Unit // Add this parameter
) {

    var addressText by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            onClick = {},
            modifier = Modifier
                .padding(8.dp)
                .border(width = 1.dp, color = Color.White)
        )
        {
            Column (modifier = Modifier
                .background(Color.White)
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .height(170.dp)
            )  {
                Text(text = "Enter Location",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = grey
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))
//                var home by remember { mutableStateOf("")}

                InputTextField(
                    text = addressText,
                    label = "Location",
                    onTextChange = {addressText = it},
                    color = Color.Black,
//                    iconResId = R.drawable.home_home,
                    maxLength = 70,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Text
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))


                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End)
                {
                    Button(
                        onClick = {
                            if (addressText.isNotBlank()) {
                                onAddAddress(addressText) // Pass the address back to the caller
                                addressText = "" // Reset the text field
                                onDismiss() // Close the dialog
                            }
                        },
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .size(width = 60.dp, height = 30.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = blue
                        ),
                        elevation = ButtonDefaults.buttonElevation(0.dp)
                    ) {
                        androidx.compose.material3.Text(
                            text = AnnotatedString("Add"),
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = firaSans_regular,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
        }
    }
}