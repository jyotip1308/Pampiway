package com.example.pampiway.martScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.components.CounterButton
import com.example.pampiway.components.DottedDivider
import com.example.pampiway.components.FoodCard
import com.example.pampiway.components.HotDealProductCard
import com.example.pampiway.components.RedBorderButton
import com.example.pampiway.components.RedButton
import com.example.pampiway.components.TopNavigationBar
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.ui.theme.textGrey
import com.example.pampiway.utility.FoodItem
import com.example.pampiway.utility.HotDealProduct
import com.example.pampiway.utility.MartCartProduct
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium
import com.example.pampiway.utility.robot_regular

@Preview
@Composable
fun MartCartScreen() {

    val products = listOf(
        MartCartProduct(name = "Papaya", price = "₹ 60/1kg", imageResId = R.drawable.fruits),
        MartCartProduct(name = "Apple", price = "₹ 100/1kg", imageResId = R.drawable.fruits),
        MartCartProduct(name = "Mango", price = "₹ 80/1kg", imageResId = R.drawable.fruits),
        MartCartProduct(name = "Banana", price = "₹ 40/1kg", imageResId = R.drawable.fruits)
        )


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
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 17.dp, end = 17.dp, top = 64.dp, bottom = 26.dp),
        ) {
            item {

                Row( modifier = Modifier.fillMaxWidth()
                    .padding(end = 16.dp, bottom = 4.dp),
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = "Location"
                    )
                    Column {

                        Text(
                            text = "Delivery address",
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = firasans_medium
                        )
                        Spacer(Modifier.height(1.dp))
                        Text(
                            text = "Mega Highway ",
                            fontSize = 12.sp,
                            color = textGrey,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = firasans_medium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                DottedDivider(
                    color = red,
                    dotRadius = 1.dp,
                    spacing = 4.dp
                )

                Spacer(modifier = Modifier.height(8.dp))


                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    Text( text = "Item in your cart",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = firasans_bold
                    )

                    Text( text = "+ Add More",
                        color = red,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = firasans_medium
                    )
                }
            }


            item {
                Spacer(modifier = Modifier.height(8.dp))

                products.forEach { product ->
                    MartCartItem(
                        product = product,
                        onQuantityChange = { newQuantity ->
                            product.quantity = newQuantity
                        }
                    )
                }
            }

            item {
                Text("Add More Item",
                    fontSize = 16.sp,
                    fontFamily = firasans_bold,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 28.dp)
                )

                CartItem()

                Spacer(modifier = Modifier.height(16.dp))

                DottedDivider(
                    color = red,
                    dotRadius = 1.dp,
                    spacing = 4.dp
                )

                DeliveryTime()

                Spacer(modifier = Modifier.height(16.dp))

                DottedDivider(
                    color = red,
                    dotRadius = 1.dp,
                    spacing = 4.dp
                )

                Text( text = "Offer & Benefit",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = firasans_bold,
                    modifier = Modifier.padding(top = 16.dp)

                )

                Button(
                    onClick = {  },
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .padding(top = 14.dp)
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

                Spacer(modifier = Modifier.height(24.dp))

                DottedDivider(
                    color = red,
                    dotRadius = 1.dp,
                    spacing = 4.dp
                )

                BillDetails()

                Spacer(modifier = Modifier.height(24.dp))

                RedButton("Make Payment") { }

                Spacer(modifier = Modifier.height(10.dp))

                RedBorderButton("Cash On Delivery") { }
            }
        }
    }
}


@Composable
fun CartItem() {
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
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp),
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

@Composable
fun DeliveryTime(){
    Row(modifier = Modifier
        .fillMaxWidth()
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


@Composable
fun BillDetails(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 24.dp)
        .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp)))
    {
        Column (modifier = Modifier.padding(12.dp)){

            Text( text = "Bill Details",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = firasans_bold
            )

            BillText("subtotal", "540")
            BillText("coin", "- 40")
            BillText("delivery fee | 3.5 km", "50")
            BillText("GST & Other Fees", "30")

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {

                Text( text = "Total",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = firasans_bold
                )

                Text( text = "550",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = firasans_bold
                )
            }

        }
    }
}

@Composable
fun BillText(text: String, bill: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {

        Text(
            text = text,
            color = Color.Black,
            fontSize = 13.sp,
            fontFamily = firaSans_regular
        )

        Text(
            text = bill,
            fontSize = 13.sp,
            fontFamily = firaSans_regular,
            color = Color.Black
        )
    }
}



//@Preview
@Composable
fun MartCartItem(
    product: MartCartProduct,
    onQuantityChange: (Int) -> Unit
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 4.dp, start = 8.dp, end = 26.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    )  {

        Row (verticalAlignment = Alignment.CenterVertically){
            // Image Section
            Image(
                painter = painterResource(id = R.drawable.fruits),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
            )


            // Product Details
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                androidx.compose.material.Text(
                    text = "Papaya",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))
                androidx.compose.material.Text(
//                text = "₹${hotDealProduct.price}/${hotDealProduct.quantity}",
                    text = "₹ 60/1kg",
                    fontSize = 12.sp,
                    color = Color.Gray
                )


            }
        }

        // Counter Button Section
        CounterButton(
            count = product.quantity,
            onCountChange = { newCount ->
                onQuantityChange(newCount)
            },
            minCount = 0,
            maxCount = 30
        )
    }
}




