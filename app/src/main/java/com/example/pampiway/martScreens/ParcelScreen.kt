package com.example.pampiway.martScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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
import androidx.navigation.NavHostController
import com.example.pampiway.R
import com.example.pampiway.components.SmallButton
import com.example.pampiway.mainScreens.InputText
import com.example.pampiway.ui.theme.darkGrey
import com.example.pampiway.ui.theme.lightBlack
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.firasans_bold

@Composable
fun ParcelScreen() {
    Column(
    modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(vertical = 16.dp, horizontal = 12.dp)
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 0.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start)
        {

            Image(
                painterResource(id = R.drawable.arrow_back),
                contentDescription = "back",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        MyComponents.navController.popBackStack()
                    },
                contentScale = ContentScale.Fit)
            

            Text(text = "Parcel",
                style = TextStyle(
                    fontFamily = firasans_bold,
                    fontWeight = FontWeight.Bold,
                    color = lightBlack,
                    fontSize = 26.sp
                ), modifier = Modifier.padding(start = 8.dp)
            ) 
        }


        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painterResource(id = R.drawable.ic_parcelride),
                    contentDescription = "image",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .padding(24.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(4.dp))
                ParcelContent()

            }
            SmallButton(onClick = {

            }, text = "Continue" )
        }
            //SmallComponents()

    }

}





@Composable
fun ParcelContent() {


    Column(
        modifier = Modifier
            .fillMaxWidth(), verticalArrangement = Arrangement.Center

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ColumnWithCenteredCirclesParcel()
            ColumnWithTextParcel()
        }
    }
}

@Composable
fun ColumnWithTextParcel() {
    val pickuplocation = remember {
        mutableStateOf("")
    }

    val droplocation = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(start = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight(), // Wrap height to content
        horizontalAlignment = Alignment.Start // Align items to the start horizontally
    ) {
        InputText(
            modifier = Modifier
                .padding(top = 2.dp, bottom = 4.dp),
            text = pickuplocation.value,
            color = lightBlack,
            maxLine = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text),
            onTextChange = { pickuplocation.value = it },
            maxLength = 100
        )

        Spacer(modifier = Modifier.height(32.dp))
        InputText(
            modifier = Modifier
                .padding(top = 2.dp, bottom = 4.dp),
            text = droplocation.value,
            color = lightBlack,
            maxLine = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text),
            onTextChange = { droplocation.value = it },
            maxLength = 100
        )
    }
}

@Preview
@Composable
fun CenteredCirclesParcel(mode: Int = 1) {
    Box(
        contentAlignment = Alignment.Center, // Centers content inside the box
        modifier = Modifier.size(13.dp) // Ensures enough space for circles
    ) {
        // Circle A
        Box(
            modifier = Modifier
                .size(13.dp) // Size of Circle A
                .background(
                    color = if (mode == 1) darkGrey else Color.White,
                    shape = if (mode == 1) CircleShape else RoundedCornerShape(0.dp)
                ),
            contentAlignment = Alignment.Center // Ensure the rotated content stays centered
        ) {
            if (mode != 1) {
                // Rotated dark grey inner box for non-circle shapes
                Box(
                    modifier = Modifier
                        .size(13.dp)
                        .rotate(45f) // Rotate this child content
                        .background(color = darkGrey, shape = RoundedCornerShape(0.dp)) // Inner dark grey box
                )
            }
        }
    }
}


@Composable
fun ColumnWithCenteredCirclesParcel() {
    Column(
        modifier = Modifier
            .padding(start = 8.dp, bottom = 8.dp)
            .width(40.dp)
            .wrapContentHeight(), // Wrap height to content
        horizontalAlignment = Alignment.Start
        // Center items horizontally
    ) {
        // Circle A
        CenteredCirclesParcel(mode = 1)

        // Vertical line
        Box(
            modifier = Modifier
                .padding(start = 5.5.dp)
                .width(2.dp) // Line width
                .height(80.dp) // Adjust height as per the gap you want between circles
                .background(darkGrey)
        )

        // Circle B
        CenteredCirclesParcel(mode = 2)
    }
}
