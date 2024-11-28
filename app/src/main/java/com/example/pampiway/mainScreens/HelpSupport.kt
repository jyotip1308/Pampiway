package com.example.pampiway.mainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.components.RedBorderButton
import com.example.pampiway.components.RedButton
import com.example.pampiway.ui.theme.darkGrey
import com.example.pampiway.ui.theme.lightBlack
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium

@Preview
@Composable
fun HelpSupport() {

    Column(
    modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(vertical = 16.dp, horizontal = 12.dp)
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){

            Image(
                painterResource(id = R.drawable.arrow_back),
                contentDescription = "back",
                modifier = Modifier.size(32.dp).clickable {
                    MyComponents.navController.popBackStack()
                },
                contentScale = ContentScale.Fit)
            

            Text(text = "Help & Support",
                style = TextStyle(
                    fontFamily = firasans_bold,
                    fontWeight = FontWeight.Bold,
                    color = lightBlack,
                    fontSize = 26.sp
                ), modifier = Modifier.padding(start = 8.dp)
            ) 
        }

        Divider(
            color = Color.White,              // Set the color of the divider
            thickness = 4.dp,                // Set the thickness of the divider
            modifier = Modifier.fillMaxWidth() // Make the divider take full width
        )



        Spacer(modifier = Modifier.height(4.dp))

        InputHelp(text = "helpc")

    }

}

@Composable
fun InputHelp(text: String) {

    var inputSubject by remember { mutableStateOf("") }
    var inputMessage by remember { mutableStateOf("") }

    Text(text = "Subject",
        style = TextStyle(
            fontFamily = firaSans_regular,
            color = darkGrey,
            fontSize = 20.sp
        )
    )

    Spacer(modifier = Modifier.height(12.dp))

    InputText(
        modifier = Modifier
            .padding(top = 2.dp, bottom = 4.dp),
        text = inputSubject,
        color = Color.Black,
        maxLine = 1,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email),
        onTextChange = { inputSubject = it },
        maxLength = 10
    )


    Spacer(modifier = Modifier.height(24.dp))

    Text(text = "Message",
        style = TextStyle(
            fontFamily = firaSans_regular,
            color = darkGrey,
            fontSize = 20.sp
        )
    )

    Spacer(modifier = Modifier.height(12.dp))

    InputTextLarge(
        modifier = Modifier
            .padding(top = 2.dp, bottom = 4.dp),
        text = inputMessage,
        color = Color.Black,
        maxLine = 1,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password),
        onTextChange = { inputMessage = it },
        maxLength = 10
    )

    Spacer(modifier = Modifier.height(48.dp))

   RedButton("Raise A Query", buttonHeight = 40.dp) {

   }
    Spacer(modifier = Modifier.height(4.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Divider(
            color = lightBlack, // Set the color of the divider
            thickness = 2.dp, // Set the thickness of the divider
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center) // Center the divider vertically within the Box
        )
        Text(
            text = "Or",
            style = TextStyle(
                fontFamily = firasans_medium,
                fontWeight = FontWeight.Medium,
                color = lightBlack,
                fontSize = 20.sp
            ),
            modifier = Modifier
                .align(Alignment.Center) // Center the text within the Box
                .background(Color.White)
                .padding(8.dp) // Optional padding
        )


    }

    Spacer(modifier = Modifier.height(4.dp))

    RedBorderButton("Call Us", buttonHeight = 40.dp) {

    }
}

