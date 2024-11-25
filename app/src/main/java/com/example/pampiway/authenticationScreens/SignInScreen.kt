package com.example.pampiway.authenticationScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pampiway.R
import com.example.pampiway.components.InputTextField
import com.example.pampiway.components.RedButton
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.VERIFICATION
import com.example.pampiway.utility.firasans_medium

//@Preview
@Composable
fun SignIn(navController: NavController){

    var mobNum by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(R.drawable.rectangle),
            contentDescription = "Rectangle",
            modifier = Modifier.size(350.dp)
        )

        Text(text = "Sign in",
            fontSize = 30.sp,
            color = red,
            fontWeight = FontWeight.SemiBold,
            fontFamily = firasans_medium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column (modifier = Modifier.fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp)){

            Text(text = "Enter phone number",
                fontSize = 13.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium
            )
            Spacer(modifier = Modifier.height(10.dp))

            InputTextField(
                modifier = Modifier
                    .padding(0.dp),
                text = mobNum,
                color = Color.Black,
                label = "Mobile Number",
                iconResId = R.drawable.flag_india,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onTextChange = { mobNum = it },
                maxLength = 12
            )

            Spacer(modifier = Modifier.height(64.dp))

            RedButton("Continue", buttonHeight = 45.dp) {
                MyComponents.mainViewModel.login(phone_number = mobNum)
//                navController.navigate(VERIFICATION)
            }

            Spacer(modifier = Modifier.height(4.dp))
            StyledText()
        }
    }
}


@Composable
fun StyledText() {
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