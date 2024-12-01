package com.example.pampiway.martScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.components.DiscountFoodCard
import com.example.pampiway.components.FoodCard
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.lightRed
import com.example.pampiway.ui.theme.red
import com.example.pampiway.ui.theme.textGrey
import com.example.pampiway.ui.theme.topGrey
import com.example.pampiway.utility.DiscountMenu
import com.example.pampiway.utility.RatingFood
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium


@Preview
@Composable
fun AdharMart() {

    Column(modifier = Modifier.fillMaxSize()
        .background(Color.White)
    ) {
        // Top AppBar
        TopAppBar(
            backgroundColor = topGrey, // Set your desired color here
            elevation = 4.dp, // Optional: Control the shadow effect
            title = {},
            navigationIcon = {
                IconButton(onClick = { /* Handle back click */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            actions = {
                IconButton(onClick = { /* Handle search */ }) {
                    Icon(Icons.Default.Search,
                        contentDescription = "Search",
                        tint = red
                    )
                }
            }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Restaurant Header Section
            item {
                RestaurantHeader()
            }
        }
    }
}

@Composable
fun RestaurantHeader() {
    Column(modifier = Modifier.padding(vertical = 16.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Burger King",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Burger • Fast Food",
            fontSize = 13.sp,
            color = textGrey,
            fontFamily = firaSans_regular
        )

        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            
            Row(
                modifier = Modifier
                    .background(color = red, shape = RoundedCornerShape(4.dp))
                    .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "4.5", fontWeight = FontWeight.Bold,
                    fontFamily = firasans_medium,
                    fontSize = 12.sp,
                    color = Color.White)
            }
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "100+ ratings", color = textGrey,
                fontSize = 12.sp,
                fontFamily = firaSans_regular
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row (modifier = Modifier
            .background(color = lightRed, shape = RoundedCornerShape(36.dp))
            .padding(top = 8.dp, bottom = 8.dp, start = 28.dp, end = 28.dp),
            verticalAlignment = Alignment.CenterVertically){

            Icon(
                painter = painterResource(id = R.drawable. clock),
                contentDescription = "Rating",
                tint = red,
                modifier = Modifier.size(16.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(text = "30-35 min.2 Km", color = textGrey,
                fontFamily = firaSans_regular
            )

            Spacer(modifier = Modifier.width(6.dp))

            VerticalDivider(modifier = Modifier.height(16.dp),
                thickness = 2.dp,
                color = grey
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(text = "main market", color = textGrey,
                fontFamily = firaSans_regular
            )
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = red,
        fontFamily = firasans_bold,
        modifier = Modifier.fillMaxWidth()
        .padding(top = 8.dp),
        textAlign = TextAlign.Start
    )
}
