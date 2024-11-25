package com.example.pampiway.authenticationScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pampiway.R
import com.example.pampiway.components.RedButton
import com.example.pampiway.components.TopNavigationBar
import com.example.pampiway.ui.theme.green
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.utility.LOCATION
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.firasans_medium

//@Preview
@Composable
fun Verification(navController: NavController){

    var otpText by remember { mutableStateOf(MyComponents.mainViewModel.otp.value) } // State for OTP input

    Scaffold(
        topBar = {
            TopNavigationBar(
                title = "Verify your details",
                onBackClick = {  }
            )
        }
    ) { it->

        Column(
            modifier = Modifier.fillMaxSize()
                .background(color = Color.White)
                .padding(start = 16.dp, end = 16.dp, top = 72.dp)
        )

        {
           /* Icon(
                painter = painterResource(R.drawable.arrow_back),
                contentDescription = "Back Arrow",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Verify your details",
                fontSize = 22.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium
            )*/

            Spacer(modifier = Modifier.height(16.dp))

            val styledText = buildAnnotatedString {
                // First part with bold and red color
                withStyle(
                    style = SpanStyle(
                        color = grey,
                        fontSize = 12.sp,
                        fontFamily = firasans_medium
                    )
                ) {
                    append("Enter otp sent to ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = firasans_medium, fontSize = 12.sp
                    )
                ) {
                    append("+91 ${MyComponents.mainViewModel.phone_number.value} ")
                }

                withStyle(
                    style = SpanStyle(
                        color = grey,
                        fontSize = 12.sp
                    )
                ) {
                    append("Via Sms")
                }
            }

            // Display the styled text in a Text composable
            Text(text = styledText,)

            Text(
                text = "Enter OTP",
                fontSize = 15.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium
            )

            OTPInput(otpText = otpText,
                onOtpTextChange = { newOtp -> otpText = newOtp }) // Update OTP state


            Spacer(modifier = Modifier.height(64.dp))

            Column(
                modifier = Modifier.fillMaxSize(0.5f),
                verticalArrangement = Arrangement.Bottom
            ) {
            }
            RedButton("Verify & Continue", buttonHeight = 45.dp) {
//                navController.navigate(LOCATION)
                MyComponents.mainViewModel.verification(MyComponents.mainViewModel.phone_number.value, MyComponents.mainViewModel.otp.value)
            }

            Spacer(modifier = Modifier.height(8.dp))

            VerifyStyleText()


        }

    }
}

@Composable
fun OTPInput(
    otpText: String = "",
    onOtpTextChange: (String) -> Unit,
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 19.dp)) {
        BasicTextField(
            value = otpText,
            onValueChange = {
                if (it.length <= 6 ) {
                    onOtpTextChange.invoke(it)
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions {
                ImeAction.Next
                keyboardController?.hide()
            }
        ){
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                repeat(6){index ->
                    val  num = when {
                        index >= otpText.length -> ""
                        else -> otpText[index]
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Box(modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .border(width = 1.dp, color = Color.Gray),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = num.toString(),
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 16.sp
                                )
                            )
                        }
                    }
                }
            }
        }

    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween){

        val styledText = buildAnnotatedString {
            // First part with bold and red color
            withStyle(style = SpanStyle(color = grey,
                fontSize = 12.sp,
                fontFamily = firasans_medium)
            ) {
                append("Didn’t receive otp? ")
            }
            withStyle(style = SpanStyle(color = green,
                fontFamily = firasans_medium, fontSize = 12.sp)
            ) {
                append("Resend ")
            }
        }

        Text(text = styledText,
            modifier = Modifier.padding(start = 8.dp)
        )

        Text(text = "00:59",
            color = Color.Black,
            style = TextStyle(
                fontSize = 12.sp
            )
        )
    }

}

@Composable
fun VerifyStyleText() {
    // Use buildAnnotatedString to define text with multiple styles
    val styledText = buildAnnotatedString {
        // First part with bold and red color
        withStyle(style = SpanStyle(color = grey,
            fontSize = 12.sp,
            fontFamily = firasans_medium)) {
            append("By clicking,i accept the ")
        }
        withStyle(style = SpanStyle(color = Color.Black,
            fontFamily = firasans_medium, fontSize = 12.sp)) {
            append("terms&conditions ")
        }
        withStyle(style = SpanStyle(color = grey,
            fontSize = 12.sp)) {
            append("& ")
        }

        withStyle(style = SpanStyle(color = Color.Black,
            fontSize = 12.sp,
            fontFamily = firasans_medium)) {
            append("privacy policy")
        }
    }

    // Display the styled text in a Text composable
    Text(
        text = styledText,
    )
}