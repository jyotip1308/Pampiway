package com.example.pampiway.martScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pampiway.R
import com.example.pampiway.components.FoodCard
import com.example.pampiway.components.HotDealProductCard
import com.example.pampiway.components.MenuCard
import com.example.pampiway.components.RestaurantCard
import com.example.pampiway.components.SearchBarMenu
import com.example.pampiway.mainScreens.LazyRowProductMenu
import com.example.pampiway.mainScreens.OfferBannerMenu
import com.example.pampiway.navigationScreen.BottomNavigationBar
import com.example.pampiway.ui.theme.blue
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.ui.theme.topGrey
import com.example.pampiway.ui.theme.yellow
import com.example.pampiway.utility.CART
import com.example.pampiway.utility.HotDealProduct
import com.example.pampiway.utility.MARTCARTSCREEN
import com.example.pampiway.utility.Menu
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.Product
import com.example.pampiway.utility.RatingFood
import com.example.pampiway.utility.Restaurant
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium

@Composable
fun MartDashboard(navController: NavHostController) {

    // Sample product data
    val products = listOf(
        Product("Fruits And Vegetables", R.drawable.fruits),
        Product("Milk, Bread And Eggs", R.drawable.milk_bread_eggs),
        Product("Dry Fruits And Masala", R.drawable.dry_fruits_masala),
        Product("Snacks And Bakery", R.drawable.fruits),
        Product("Kitchen Essential", R.drawable.fruits),
        Product("Juice And Cold Drinks", R.drawable.milk_bread_eggs),
        Product("Electronics", R.drawable.milk_bread_eggs),
        Product("Stationery", R.drawable.milk_bread_eggs),
        Product("Stationery", R.drawable.milk_bread_eggs),
        Product("Stationery", R.drawable.milk_bread_eggs),
        Product("Stationery", R.drawable.milk_bread_eggs),
        Product("Stationery", R.drawable.milk_bread_eggs),
        Product("Extra Product", R.drawable.milk_bread_eggs) // Example for additional products
    )

    var showAllProducts by remember { mutableStateOf(false) }

    var searchQuery by remember { mutableStateOf("") } // Keeps track of the search text


    Scaffold(
        topBar = { TopBarMenu() },
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues -> // Capture the PaddingValues provided by Scaffold
        Column(
            modifier = Modifier
//                .fillMaxSize()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                .padding(paddingValues) // Apply the padding to avoid overlapping with the BottomNavigationBar
        ) {

            // SearchBar Integration
            SearchBarMenu(
                query = searchQuery,
                onQueryChanged = { query ->
                    searchQuery = query
                },
                onClearQuery = {
                    searchQuery = "" // Clear the search query
                },
                modifier = Modifier.padding(vertical = 6.dp)
            )


            LazyColumn(
                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.spacedBy(14.dp),
//                contentPadding = PaddingValues(bottom = 16.dp)
            ) {

                // LazyVerticalGrid inside LazyColumn
                item {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        contentPadding = PaddingValues(3.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .heightIn(max = 500.dp) // Adjust height to fit content
                    ) {
                        val displayProducts = if (showAllProducts) products else products.take(8)

                        items(displayProducts) { product ->
                            ProductCard(product)
                        }

                        if (!showAllProducts) {
                            item {
                                MoreCard {
                                    showAllProducts = true
                                }
                            }
                        }
                    }
                }

                // Additional content after the grid
                items(1) {
                   OfferBannerMenu()
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Hot Deal",
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontFamily = firasans_medium,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    HotDeals()

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


                // Third icon (ShoppingCart)
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "Shopping Cart",
                    modifier = Modifier.size(24.dp)
                        .clickable {
                        MyComponents.navController.navigate(MARTCARTSCREEN)
                        },
//                    tint = red
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
fun ProductCard(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = product.imageResId),
                contentDescription = product.name,
                modifier = Modifier.fillMaxSize(), // Ensure the image fills the entire Box
            contentScale = ContentScale.Crop,
            )
        }
        Text(
            text = product.name,
            fontSize = 12.sp,
            color = Color.Black,
            fontFamily = firasans_bold,
            fontWeight = FontWeight.Bold,
            maxLines = 2, // Limit the text to 2 lines
            overflow = TextOverflow.Ellipsis, // Add ellipsis if the text is too long
//            textAlign = TextAlign.Center, // Center-align the text
            softWrap = true,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MoreCard(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp))
            .aspectRatio(1f)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {

        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(Icons.Default.Add, contentDescription = "More",
                modifier = Modifier.size(24.dp),
                tint = red
            )
            Text(
                text = " More",
                fontSize = 13.sp,
                color = red,
                fontFamily = firasans_bold,
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

@Composable
fun HotDeals(){
    val products = listOf(
        HotDealProduct(
            name = "Lays Salted Chips",
            price = "90",
            quantity = "120g",
            imageResId = R.drawable.lays,
            discount = "10% Off"
        ),
        HotDealProduct(
            name = "Saffola Oats",
            price = "190",
            quantity = "500g",
            imageResId = R.drawable.lays,
            discount = "10% Off"
        ),
        HotDealProduct(
            name = "Saffola Oats",
            price = "190",
            quantity = "500g",
            imageResId = R.drawable.lays,
            discount = "10% Off"
        ),
        HotDealProduct(
            name = "Saffola Oats",
            price = "190",
            quantity = "500g",
            imageResId = R.drawable.lays,
            discount = "10% Off"
        )
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products) { product ->
            HotDealProductCard (
                hotDealProduct = product,
                onAddClick = { /* Handle Add Click */ }

            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMenuScreen() {
    val moNavController = rememberNavController() // Create a mock NavController for preview
    MartDashboard(navController = moNavController)
}