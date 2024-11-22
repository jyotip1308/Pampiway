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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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
import com.example.pampiway.components.MenuCard
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
fun MenuScreen(navController: NavController) {
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
            TopBarMenu()

            Spacer(modifier = Modifier.height(14.dp))
            SearchBarMenu()
            Spacer(modifier = Modifier.height(14.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
//                contentPadding = PaddingValues(bottom = 16.dp)
            ) {

                item { ProductMenu1() }

                item { ProductMenu2() }

                item { OfferBannerMenu() }

                item {
                    Row(modifier = Modifier.fillMaxWidth()
                        .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {

                        Text(
                            text = "Top Rated Restaurants",
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontFamily = firasans_medium,
                            fontWeight = FontWeight.Bold,
                        )

                        Text(
                            text = "View All",
                            fontSize = 10.sp,
                            color = red,
                            fontFamily = firasans_medium,
                        )
                    }
                }

                item { LazyRowProductMenu() }
            }
        }
    }
}


@Composable
fun TopBarMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Hii, Rahul",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium
            )

            Spacer(Modifier.height(8.dp))
            Text(text = "Good Morning",
                fontSize = 18.sp,
                color = red,
                fontWeight = FontWeight.SemiBold,
                fontFamily = firasans_medium
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
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
fun SearchBarMenu() {
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
            text = "Search for \"grocery\"",
            color = Color.Gray,
            modifier = Modifier.weight(1f)
        )
//        Icon(Icons.Default.Mic, contentDescription = "Mic Icon")
    }
}

@Composable
fun ProductMenu1() {
    LazyRow (
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item{
            MenuCard(
                imageResId = R.drawable.burger_,
                name = "Burger",
            )
        }

        item{
            MenuCard(
                imageResId = R.drawable.momos_,
                name = "Momos",
            )
        }

        item{
            MenuCard(
                imageResId = R.drawable.pizza_,
                name = "Pizza",
            )
        }

        item{
            MenuCard(
                imageResId = R.drawable.burger_,
                name = "Burger",
            )
        }
    }
}

@Composable
fun ProductMenu2() {
    LazyRow (
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item{
            MenuCard(
                imageResId = R.drawable.laddoo,
                name = "Sweet",
            )
        }

        item{
            MenuCard(
                imageResId = R.drawable.thali_,
                name = "Thali",
            )
        }

        item{
            MenuCard(
                imageResId = R.drawable.pasta_,
                name = "Pasta",
            )
        }

        item{
            MenuCard(
                imageResId = R.drawable.pizza_,
                name = "Pizza",
            )
        }
    }
}

@Composable
fun LazyRowProductMenu() {
    LazyRow (
        modifier = Modifier
            .fillMaxSize(),
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
fun OfferBannerMenu() {
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
fun PreviewMenuScreen() {
    val moNavController = rememberNavController() // Create a mock NavController for preview
        MenuScreen(navController = moNavController)
}




