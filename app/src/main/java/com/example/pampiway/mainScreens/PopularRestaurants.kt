package com.example.pampiway.mainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.components.TopNavigationBarArrow
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.ui.theme.topGrey
import com.example.pampiway.utility.CART
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.PopularRestaurant
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium

@Preview
@Composable
fun PopularRestaurantsScreen() {
    val listItem = listOf(
        PopularRestaurant(
            imageResId = R.drawable.burger_image,
            name = "Burger Singh",
            description = "Burger • Fast Food",
            distance = "2 Km",
            deliveryTime = "35 min",
            rating = "4.5"
        ),
        PopularRestaurant(
            imageResId = R.drawable.burger_image,
            name = "Burger Singh",
            description = "Burger • Fast Food",
            distance = "2 Km",
            deliveryTime = "35 min",
            rating = "4.5"
        ),
        PopularRestaurant(
            imageResId = R.drawable.burger_image,
            name = "Burger Singh",
            description = "Burger • Fast Food",
            distance = "2 Km",
            deliveryTime = "35 min",
            rating = "4.5"
        ),
        PopularRestaurant(
            imageResId = R.drawable.burger_image,
            name = "Burger Singh",
            description = "Burger • Fast Food",
            distance = "2 Km",
            deliveryTime = "35 min",
            rating = "4.5"
        )
    )

    Scaffold(
        topBar = {
           TopNavigationBarArrow(
                onBackClick = {  }
            )
        }
    ) { it ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp, top = 72.dp,)
        ) {
            // Top header
            Text(
                text = "Burger",
                color = Color.Red,
                fontFamily = firasans_bold,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Popular Restaurants",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = firasans_medium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Restaurant cards in a list
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(listItem) { item ->
                    RestaurantCard(item)
                }
            }
        }
    }
}


@Composable
fun RestaurantCard(
    popularRestaurant: PopularRestaurant
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(12.dp)),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Image Section
            Image(
                painter = painterResource(popularRestaurant.imageResId),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Allocate space proportionally
            )

            // Details Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = popularRestaurant.name,
                        fontSize = 14.sp,
                        fontFamily = firasans_bold,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    // Star Icon and Rating
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = "Star",
                            tint = Color(0xFFFFA000), // Yellow color
                            modifier = Modifier.size(16.dp) // Visible size
                        )
                        Spacer(modifier = Modifier.width(4.dp)) // Add spacing between icon and text
                        Text(
                            text = popularRestaurant.rating,
                            fontSize = 12.sp,
                            color = grey,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = popularRestaurant.description,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    // Location and Delivery Time
                    Text(
                        text = "${popularRestaurant.distance} • ${popularRestaurant.deliveryTime}",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

