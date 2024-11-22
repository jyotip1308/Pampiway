package com.example.pampiway.mainScreens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pampiway.R
import com.example.pampiway.components.CounterButton
import com.example.pampiway.components.InputTextField
import com.example.pampiway.components.RedButton
import com.example.pampiway.components.TopNavigationBar
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.VERIFYDETAILS
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_medium
import com.example.pampiway.utility.robot_regular

@Preview
@Composable
fun CartScreen() {
    Scaffold(
        topBar = {
            TopNavigationBar(
                title = "Cart",
                onBackClick = {  }
            )
        }
    ) {it ->
        // Screen content here
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(start = 17.dp, end = 17.dp, top = 64.dp),
        ) {
            item {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text( text = "Item in your cart",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = firasans_medium
                    )

                    Text( text = "+ Add More",
                        color = red,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = firasans_medium
                    )
                }
            }

            item { AddFood() }
            item { AddFood() }

            item {
                Text("Complete Your Meal",
                    fontSize = 16.sp,
                    fontFamily = firaSans_regular,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 28.dp)
                )

                Divider(color = red,
                    modifier = Modifier.padding(top = 12.dp)
                )

                DeliveryTime()

                Divider(color = red,
                    modifier = Modifier.padding(top = 12.dp)
                )

                Text( text = "Offer & Benefit",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = firasans_medium,
                    modifier = Modifier.padding(top = 28.dp)

                )

                Button(
                    onClick = {  },
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .padding(top = 36.dp)
                        .fillMaxWidth()
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = red
                    ),
                    elevation = ButtonDefaults.buttonElevation(0.dp)
                ) {

                    Text(
                        text = AnnotatedString("Use Coins & Promocode"),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = firaSans_regular,
                        ),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

            }

        }
    }
}

@Composable
fun AddFood(){

    var count1 by remember { mutableIntStateOf(0) } // External state for Counter 1

    Row(modifier = Modifier.fillMaxWidth()
        .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Paneer Burger",
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = firasans_medium
        )

        Spacer(modifier = Modifier.width(20.dp))
        CounterButton(
            count = count1,
            onCountChange = { count1 = it },
            minCount = 0,
            maxCount = 30
        )
       Text(
            text = "₹180",
            fontSize = 12.sp,
            fontFamily = robot_regular,
            color = Color.Black
       )
    }
}

@Composable
fun DeliveryTime(){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically) {

        Icon(
            painter = painterResource(id = R.drawable.clock),
            modifier = Modifier.size(16.dp),
            tint = Color.Unspecified,
            contentDescription = "Favorite Icon"
        )

        Text(
            text = "  Delivery in",
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = firaSans_regular
        )

        Text(
            text = " 30-35 mins.",
            fontSize = 15.sp,
            fontFamily = firasans_medium,
            color = red
        )
    }
}





