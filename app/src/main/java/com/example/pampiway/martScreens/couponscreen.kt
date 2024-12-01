package com.example.pampiway.martScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.R
import com.example.pampiway.components.SmallButton
import com.example.pampiway.ui.theme.darkGrey
import com.example.pampiway.ui.theme.lightBlack
import com.example.pampiway.ui.theme.lightGrey
import com.example.pampiway.ui.theme.mgreen
import com.example.pampiway.ui.theme.mred
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium

@Composable
fun couponscreen() {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        val currentCoupon by remember {
            mutableStateOf("")
        }

        val coins by remember {
            mutableStateOf(0)
        }

        val availableCoins by remember {
            mutableStateOf(0)
        }

        var selected by remember { mutableStateOf(false) }

        val coupons = listOf(
            Coupon(R.drawable.ic_couponimage, "TRYTONEW50", "50% OFF UP TO 100"),
            Coupon(R.drawable.ic_couponimage, "SAVE20", "20% OFF UP TO 50"),
            Coupon(R.drawable.ic_couponimage, "GET30", "30% OFF ON ORDER"),
            Coupon(R.drawable.ic_couponimage, "TRYTONEW50", "50% OFF UP TO 100"),
            Coupon(R.drawable.ic_couponimage, "SAVE20", "20% OFF UP TO 50"),
            Coupon(R.drawable.ic_couponimage, "GET30", "30% OFF ON ORDER"),
            Coupon(R.drawable.ic_couponimage, "TRYTONEW50", "50% OFF UP TO 100"),
            Coupon(R.drawable.ic_couponimage, "SAVE20", "20% OFF UP TO 50"),
            Coupon(R.drawable.ic_couponimage, "GET30", "30% OFF ON ORDER")
        )

        // This Column handles the content and the button separately.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween // Ensures bottom alignment
        ) {
            // Top content
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp, bottom = 6.dp, end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(horizontalArrangement = Arrangement.Start) {
                        Image(
                            painterResource(id = R.drawable.arrow_back),
                            contentDescription = "back",
                            modifier = Modifier
                                .size(32.dp)
                                .clickable {
                                    MyComponents.navController.popBackStack()
                                },
                            contentScale = ContentScale.Fit
                        )

                        Text(
                            text = "Coin & Coupons",
                            style = TextStyle(
                                fontFamily = firasans_bold,
                                fontWeight = FontWeight.Bold,
                                color = lightBlack,
                                fontSize = 22.sp
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }


                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Text(
                        text = "Available Coins",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = firasans_bold,
                        color = lightBlack
                    )

                    Text(
                        text = coins.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = firasans_bold,
                        color = mred
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        CustomRadioButton(
                            selected = selected,
                            onClick = { selected = !selected }
                        )
                        Divider(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Use Coins",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = firasans_bold,
                            color = lightBlack
                        )

                    }

                    Text(
                        text = availableCoins.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = firasans_bold,
                        color = lightBlack
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Available Coupons",
                    style = TextStyle(
                        fontFamily = firasans_bold,
                        fontWeight = FontWeight.Bold,
                        color = lightBlack,
                        fontSize = 22.sp
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )

                couponApply()
                CouponList(coupons)

            }

            // Bottom button
            Column {

            SmallButton(
                onClick = {

                },
                text = "Confirm Order"
            )
                Spacer(modifier = Modifier.height(48.dp))
        }

        }
    }
}

@Composable
fun CouponList(coupons: List<Coupon>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .padding(8.dp)
    ) {
        items(coupons) { coupon ->
            CustomRowWithElements(coupon)
            Spacer(modifier = Modifier.height(8.dp)) //Space between items
        }
    }
}


@Composable
fun CustomRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(24.dp)
            .clip(CircleShape) // Ensures the ripple is circular
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = LocalIndication.current, // Default ripple effect
                onClick = onClick
            )
            .border(
                width = 2.dp,
                color = if (selected) Color.Red else Color.Gray,
                shape = CircleShape
            )
            .background(
                color = if (selected) Color.Red else Color.Transparent,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        if (selected) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(color = Color.White, shape = CircleShape)
            )
        }
    }
}

@Preview
@Composable
fun couponApply() {
    Row(
        modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 12.dp)
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 2.dp,
                color = mred,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Available Coupons",
            style = TextStyle(
                fontFamily = firaSans_regular,
                fontWeight = FontWeight.Normal,
                color = darkGrey,
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(start = 16.dp)
        )

        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = mred),
            shape = RoundedCornerShape(topStart = 0.dp, bottomStart = 0.dp, topEnd = 8.dp, bottomEnd = 8.dp),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.height(50.dp)
        ) {
            Text(text = "Apply", style = TextStyle(
                fontFamily = firasans_medium,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                fontSize = 16.sp
            ), modifier = Modifier.padding(horizontal = 32.dp))
        }

    }

}

@Composable
fun CustomRowWithElements(coupon: Coupon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Element A: Image
            Image(
                painter = painterResource(id = coupon.imageResId), // Use image from data class
                contentDescription = "Coupon Image",
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(4.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Element B: Title and Subtitle
            Column {
                Box(
                    modifier = Modifier
                        .background(color = lightGrey, shape = RoundedCornerShape(4.dp))
                        .height(24.dp)
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = coupon.code, // Use coupon code
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = lightBlack
                        )
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = coupon.description, // Use coupon description
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = lightBlack,
                        fontFamily = firasans_bold
                    )
                )
            }
        }

        // Element B: Green Text
        Text(
            text = "APPLY",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = mgreen
            )
        )
    }
}

data class Coupon(
    val imageResId: Int,      // Resource ID for the image
    val code: String,         // Coupon code
    val description: String   // Coupon description
)