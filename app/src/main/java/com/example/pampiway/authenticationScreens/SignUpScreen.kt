package com.example.pampiway.authenticationScreens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pampiway.R
import com.example.pampiway.components.InputTextField
import com.example.pampiway.components.RedButton
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.VERIFYDETAILS
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_medium

//@Preview
@Composable
fun SignUpScreen(navController: NavHostController) {
    val context = LocalContext.current
    var fullName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var referralCode by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp))
    {
        Row(modifier = Modifier.padding(top = 26.dp)){

            Icon(painter = painterResource(R.drawable.arrow_back),
                contentDescription = "Back Arrow",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )

            Text(text = "Add your details",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium
            )
        }

        Text(
            text = "Sign Up",
            fontSize = 32.sp,
            color = red,
            fontFamily = firasans_medium,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(36.dp))

        Text(text = "Full Name",
            fontSize = 16.sp,
            color = grey,
            fontFamily = firaSans_regular
        )

        InputTextField(
            modifier = Modifier
                .padding(0.dp),
            text = fullName,
            color = Color.Black,
            label = "Full Name",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            onTextChange = { fullName = it },
            maxLength = 12
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Phone Number
        Text(text = "Phone Number",
            fontSize = 16.sp,
            color = grey,
            fontFamily = firaSans_regular
        )

        InputTextField(
            modifier = Modifier
                .padding(0.dp),
            text = phoneNumber,
            color = Color.Black,
            label = "Phone Number",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onTextChange = { phoneNumber = it },
            maxLength = 12
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email
        Text(text = "Gmail",
            fontSize = 16.sp,
            color = grey,
            fontFamily = firaSans_regular
        )

        InputTextField(
            modifier = Modifier
                .padding(0.dp),
            text = email,
            color = Color.Black,
            label = "Gmail",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            onTextChange = { email = it },
            maxLength = 12
        )


        Spacer(modifier = Modifier.height(16.dp))

        // DOB with Calendar Icon
        Text(text = "DOB",
            fontSize = 16.sp,
            color = grey,
            fontFamily = firaSans_regular
        )

        InputTextField(
            modifier = Modifier
                .padding(0.dp),
            text = dob,
            color = Color.Black,
            label = "DOB",
            trailingIconResId = R.drawable.calendar,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            onTextChange = { dob = it },
            maxLength = 12
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Referral Code
        Text(text = "Referral Code",
            fontSize = 16.sp,
            color = grey,
            fontFamily = firaSans_regular
        )

        InputTextField(
            modifier = Modifier
                .padding(0.dp),
            text = referralCode,
            color = Color.Black,
            label = "Referral Code",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onTextChange = { referralCode = it },
            maxLength = 12
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Continue Button
        RedButton("Continue", buttonHeight = 40.dp) {
            navController.navigate(VERIFYDETAILS)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Login Text
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already have an account ? ",
                fontSize = 12.sp,
                color = grey,
                fontFamily = firaSans_regular
            )

            Text(
                text = "Login",
                color = red,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = firaSans_regular,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Go to Login", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}
