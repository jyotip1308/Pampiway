package com.example.pampiway.mainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.TopAppBar
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pampiway.R
import com.example.pampiway.components.FoodCard
import com.example.pampiway.components.MenuCard
import com.example.pampiway.components.RestaurantCard
import com.example.pampiway.navigationScreen.BottomNavigationBar
import com.example.pampiway.ui.theme.blue
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.ui.theme.topGrey
import com.example.pampiway.ui.theme.yellow
import com.example.pampiway.utility.CART
import com.example.pampiway.utility.Menu
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.RatingFood
import com.example.pampiway.utility.Restaurant
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium

@Composable
fun FoodScreen(navController: NavHostController) {

    val foodList = listOf(
        RatingFood("Aloo Tikki Burger", "180", 4, "10", "Most selling burger of ours.", R.drawable.allu_tikkiburger),
        RatingFood("Aloo Tikki Burger", "180", 4, "10", "Most selling burger of ours.", R.drawable.allu_tikkiburger),
        RatingFood("Pav bhaji", "180", 4, "10", "Most selling burger of ours.", R.drawable.pav_bhaji),
        RatingFood("Pav bhaji", "180", 4, "10", "Most selling burger of ours.", R.drawable.pav_bhaji)
    )

    Scaffold(
        topBar = { TopBarMenu()},
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues -> // Capture the PaddingValues provided by Scaffold
        Column(
            modifier = Modifier
//                .fillMaxSize()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                .padding(paddingValues) // Apply the padding to avoid overlapping with the BottomNavigationBar
        ) {
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
                            fontSize = 15.sp,
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
                    LazyRowProductMenu()



                    Row(modifier = Modifier.fillMaxWidth()
                        .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {

                        Text(
                            text = "Top Rated Food",
                            fontSize = 15.sp,
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
                    Spacer(modifier = Modifier.height(8.dp))
                }


                items(foodList){ food->
                    FoodCard(
                        foodName = food.name,
                        price = food.price,
                        rating = food.rating,
                        ratingsCount = food.ratingsCount,
                        description = food.description,
                        imageResId = food.imageResId,
                        onAddClick = { }
                    )

                }
            }
        }
    }
}


@Composable
fun TopBarMenu() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
//            .height(100.dp),
        backgroundColor = topGrey,
        elevation = 4.dp,
        title = {
            Column( modifier = Modifier.fillMaxWidth()
                .padding(start = 8.dp, end = 16.dp, bottom = 4.dp)) {
                Text(
                    text = "Hii, Rahul",
                    fontSize = 15.sp,
                    color = grey,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firasans_medium
                )
                Spacer(Modifier.height(1.dp))
                Text(
                    text = "Good Morning",
                    fontSize = 15.sp,
                    color = red,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firasans_medium
                )
            }
        },
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 16.dp)
            ) {

                // Second icon (Notifications)
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    modifier = Modifier.size(24.dp),
                    tint = red
                )
                Spacer(modifier = Modifier.width(6.dp))

                // Third icon (ShoppingCart)
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = "Shopping Cart",
                    modifier = Modifier.size(24.dp)
                        .clickable {
                        MyComponents.navController.navigate(CART)
                        },
                    tint = red
                )
                Spacer(modifier = Modifier.width(6.dp))

                // Fourth icon (Account Circle)
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Account",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            }
        }
    )
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
        Icon(
            Icons.Default.Search, contentDescription = "Search Icon",
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

    val itemList = listOf(
        Menu(imageResId = R.drawable.burger_, name = "Burger"),
        Menu(imageResId = R.drawable.momos_, name = "Momos"),
        Menu(imageResId = R.drawable.pizza_, name = "Pizza"),
        Menu(imageResId = R.drawable.pizza_, name = "Pizza"),
        Menu(imageResId = R.drawable.pizza_, name = "Pizza"),
        Menu(imageResId = R.drawable.momos_, name = "Momos")
    )
    LazyRow (
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(itemList){ item->
            MenuCard(
                imageResId = item.imageResId,
                name = item.name
            )
        }
    }
}

@Composable
fun ProductMenu2() {

    val itemList = listOf(
        Menu(imageResId = R.drawable.laddoo, name = "Sweet"),
        Menu(imageResId = R.drawable.pasta_, name = "Pasta"),
        Menu(imageResId = R.drawable.laddoo, name = "Sweet"),
        Menu(imageResId = R.drawable.laddoo, name = "Sweet"),
        Menu(imageResId = R.drawable.laddoo, name = "Sweet"),
        Menu(imageResId = R.drawable.thali_, name = "Thali"),
        Menu(imageResId = R.drawable.pizza_, name = "Pizza")
    )

    LazyRow (
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(itemList){ item->
            MenuCard(
                imageResId = item.imageResId,
                name = item.name
            )
        }
    }
}

@Composable
fun LazyRowProductMenu() {

    val restaurantList = listOf(
        Restaurant(imageResId = R.drawable.food1,
            name = "Hotel Laziz",
            cuisine = "North Indian",
            rating = 4.5,
            distance = "2.1 km",
            time = "25 min"
        ),
        Restaurant(
            imageResId = R.drawable.paneer,
            name = "Hotel Swastik",
            cuisine = "North Indian",
            rating = 4.5,
            distance = "2 km",
            time = "22 min"
        ),
        Restaurant(
            imageResId = R.drawable.momos,
            name = "Momoz",
            cuisine = "Chinese",
            rating = 4.5,
            distance = "2.1 km",
            time = "25 min"
        ),
        Restaurant(
            imageResId = R.drawable.burger,
            name = "Burger",
            cuisine = "Burger king",
            rating = 4.5,
            distance = "2.1 km",
            time = "25 min"
        )
    )
    LazyRow (
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(restaurantList) { restaurant ->
            RestaurantCard(
                imageResId = restaurant.imageResId,
                name = restaurant.name,
                cuisine = restaurant.cuisine,
                rating = restaurant.rating,
                distance = restaurant.distance,
                time = restaurant.time
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
    FoodScreen(navController = moNavController)
}