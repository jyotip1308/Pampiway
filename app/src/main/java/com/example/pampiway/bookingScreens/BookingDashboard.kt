
package com.example.pampiway.bookingScreens

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pampiway.R
import com.example.pampiway.components.SearchBarMenu
import com.example.pampiway.navigationScreen.BottomNavigationBar
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.ui.theme.topGrey
import com.example.pampiway.utility.CART
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.Product
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium

@Composable
fun BookingDashboard(navController: NavHostController) {

    // Sample product data
    val products = listOf(
        Product("Electrician & Plumber", R.drawable.electrician),
        Product("Welder", R.drawable.electrician),
        Product("Carpenter", R.drawable.electrician),
        Product("Painter", R.drawable.electrician),
        Product("Architect", R.drawable.electrician),
        Product("Contractor", R.drawable.electrician),
        Product("Electronics", R.drawable.electrician),
        Product("Property Dealers", R.drawable.electrician),
        Product("Property Dealers", R.drawable.electrician),
        Product("Architect", R.drawable.electrician),
        Product("Contractor", R.drawable.electrician),
        Product("Electrician & Plumber", R.drawable.electrician),
        Product("Extra Product", R.drawable.electrician) // Example for additional products
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
                        val displayProducts = if (showAllProducts) products else products.take(5)

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
                    text = "Delivery here",
                    fontSize = 12.sp,
                    color = grey,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = firasans_medium
                )
                Spacer(Modifier.height(1.dp))

                Row (verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = "Mega Highway ",
                        fontSize = 15.sp,
                        color = red,
                        fontWeight = FontWeight.Bold,
                        fontFamily = firasans_medium
                    )

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Arrow",
                        tint = red,
                        modifier = Modifier.clickable {  }
                    )
                }
            }
        },
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 16.dp)
            ) {


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

@Preview(showBackground = true)
@Composable
fun PreviewMenuScreen() {
    val moNavController = rememberNavController() // Create a mock NavController for preview
    BookingDashboard(navController = moNavController)
}