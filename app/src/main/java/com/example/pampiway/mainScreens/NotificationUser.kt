package com.example.pampiway.mainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pampiway.R
import com.example.pampiway.ui.theme.darkGrey
import com.example.pampiway.ui.theme.lightBlack
import com.example.pampiway.ui.theme.mgreyish
import com.example.pampiway.utility.MyComponents.navController
import com.example.pampiway.utility.firaSans_regular
import com.example.pampiway.utility.firasans_bold
import com.example.pampiway.utility.firasans_medium


data class NotificationItem(
    val imageRes: Int,
    val title: String,
    val subtitle: String
)

@Composable
fun NotificationUser(navController: NavHostController) {

    val notifications = listOf(
        NotificationItem(
            imageRes = R.drawable.ic_giftred,
            title = "You have a new offer: ₹75 flat on 10 order completions",
            subtitle = "Redeem your rewards"
        ),
        NotificationItem(
            imageRes = R.drawable.ic_giftred,
            title = "Exclusive Discount: Get 20% off on your next order",
            subtitle = "Offer valid till tomorrow"
        ),
        NotificationItem(
            imageRes = R.drawable.ic_giftred,
            title = "Congratulations! You've earned a bonus",
            subtitle = "Check your wallet for details"
        )
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 12.dp)
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
            Image(
                painterResource(id = R.drawable.arrow_back),
                contentDescription = "back",
                modifier = Modifier.size(32.dp).clickable {
                    navController.popBackStack()
                },
                contentScale = ContentScale.Fit)
            Text(text = "Notification",
                style = TextStyle(
                    fontFamily = firasans_bold,
                    fontWeight = FontWeight.Bold,
                    color = lightBlack,
                    fontSize = 26.sp
                ), modifier = Modifier.padding(start = 8.dp)
            )
        }
        Divider(
            color = Color.White,              // Set the color of the divider
            thickness = 4.dp,                // Set the thickness of the divider
            modifier = Modifier.fillMaxWidth() // Make the divider take full width
        )

        NotificationListUser(notifications = notifications)

    }


}

@Composable
fun NotificationListUser(notifications: List<NotificationItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(notifications) { notification ->
            NotificationContentUser(
                imageRes = notification.imageRes,
                title = notification.title,
                subtitle = notification.subtitle
            )
        }
    }
}

@Composable
fun NotificationContentUser(
    imageRes: Int,
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(mgreyish, shape = RoundedCornerShape(8.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            // Image on the left
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Notification Image",
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp)).clickable {
                        navController.popBackStack()
                    }
            )

            Spacer(modifier = Modifier.width(8.dp)) // Space between image and text

            // Title and subtitle on the right
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = firaSans_regular,
                        color = darkGrey,
                        fontSize = 17.sp
                    )
                )
                Spacer(modifier = Modifier.height(10.dp)) // Space between title and subtitle
                Text(modifier = Modifier.padding(bottom = 10.dp),
                    text = subtitle,
                    style = TextStyle(
                        fontFamily = firasans_medium,
                        color = darkGrey,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}
