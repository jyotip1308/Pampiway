package com.example.pampiway.mainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pampiway.R
import com.example.pampiway.components.CardComponent
import com.example.pampiway.components.RestaurantCard
import com.example.pampiway.navigationScreen.BottomNavigationBar
import com.example.pampiway.ui.theme.blue
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.ui.theme.yellow
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium

//@Preview
@Composable
fun ProductHomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues -> // Capture the PaddingValues provided by Scaffold
        Column(
            modifier = Modifier
//                .fillMaxSize()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp, top = 28.dp)
                .padding(paddingValues) // Apply the padding to avoid overlapping with the BottomNavigationBar
        ) {
            TopBar()

            Spacer(modifier = Modifier.height(14.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(14.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
//                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                item { AdBanner() }
                item { Cards() }
                item { SendParcelCard() }

                item { OfferBanner() }

                item {
                    Text(
                        text = "Popular Restaurants",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = firasans_medium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }

                item { LazyRowProduct() }
            }
        }
    }
}


@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Hsr layout",
                fontSize = 18.sp,
                color = red,
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium
            )

            Spacer(Modifier.height(8.dp))
            Text(text = "Good Morning",
                fontSize = 18.sp,
                color = grey,
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.circle),
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified,
                contentDescription = "Circle")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.Notifications,
                contentDescription = "Notifications",
                modifier = Modifier.size(27.dp),
                tint = red
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.ShoppingCart,
                contentDescription = "Notifications",
                modifier = Modifier.size(27.dp),
                tint = red
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.AccountCircle,
                contentDescription = "Notifications",
                modifier = Modifier.size(27.dp),
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = red, shape = RoundedCornerShape(24.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.Search, contentDescription = "Search Icon",
            tint = red
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Search for \"food\"",
            color = Color.Gray,
            modifier = Modifier.weight(1f)
        )
//        Icon(Icons.Default.Mic, contentDescription = "Mic Icon")
    }
}

@Composable
fun AdBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("ADS HERE",
            color = red,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Cards(){
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                CardComponent(text = "Food", imageResId = R.drawable.fastfood)
                CardComponent(text = "Mart", imageResId = R.drawable.basket)
            }
            Spacer(Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                CardComponent(text = "Service", imageResId = R.drawable.lservice)
                CardComponent(text = "Booking", imageResId = R.drawable.lbooking)
            }
        }
}

//@Preview
@Composable
fun SendParcelCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(top = 8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
           Text(
                text = "Send Your Parcel \nAnywhere",
                fontSize = 18.sp,
                fontFamily = firasans_medium,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.width(16.dp)) // Space between image and text

            Image(
                painter = painterResource(id = R.drawable.parcel),
                contentDescription = "Parcel",
                modifier = Modifier
                    .size(120.dp)
                    .fillMaxWidth()
                    .align(Alignment.Bottom)
            )
        }
    }
}

@Composable
fun LazyRowProduct() {
    LazyRow (
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {

        item{
            RestaurantCard(
                imageResId = R.drawable.food1,
                name = "Hotel Laziz",
                cuisine = "North Indian",
                rating = 4.5,
                distance = "2.1 km",
                time = "25 min"
            )
        }

        item{
            RestaurantCard(
                imageResId = R.drawable.paneer,
                name = "Hotel Swastik",
                cuisine = "North Indian",
                rating = 4.5,
                distance = "2 km",
                time = "22 min"
            )
        }

        item{
            RestaurantCard(
                imageResId = R.drawable.momos,
                name = "Momoz",
                cuisine = "Chinese",
                rating = 4.5,
                distance = "2.1 km",
                time = "25 min"
            )
        }

        item{
            RestaurantCard(
                imageResId = R.drawable.burger,
                name = "Burger",
                cuisine = "Burger king",
                rating = 4.5,
                distance = "2.1 km",
                time = "25 min"
            )
        }
    }
}


@Composable
fun OfferBanner() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(top = 12.dp),
        elevation = 8.dp,
        backgroundColor = yellow,
        shape = RoundedCornerShape(8.dp),

    ) {

        Row(modifier = Modifier.fillMaxWidth()
            .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {

            Column{

                Text(
                    text = "Get up to",
                    color = blue,
                    fontSize = 14.sp,
                    fontFamily = firaSans_regular
                )

                Text(
                    text = "25% off",
                    color = blue,
                    fontFamily = firasans_bold,
                    fontWeight = FontWeight.ExtraBold, fontSize = 21.sp
                )

                Text(
                    text = "on all food orders",
                    color = blue,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firasans_medium
                )

                Button(
                    onClick = {  },
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .size(width = 85.dp, height = 35.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = blue
                    ),
                    elevation = ButtonDefaults.buttonElevation(0.dp)
                ) {
                    Text(
                        text = AnnotatedString("Order Now"),
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

            Image(
                painter = painterResource(id = R.drawable.thali),
                contentDescription = "Thali",
                modifier = Modifier
                    .size(height = 140.dp, width = 180.dp)
                    .fillMaxWidth()

            )
        }





        }
    }





@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    val mockNavController = rememberNavController() // Create a mock NavController for preview
    ProductHomeScreen(navController = mockNavController)
}
