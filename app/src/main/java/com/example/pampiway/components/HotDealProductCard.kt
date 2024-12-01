package com.example.pampiway.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampiway.ui.theme.grey
import com.example.pampiway.ui.theme.red
import com.example.pampiway.utility.HotDealProduct

@Composable
fun HotDealProductCard(
    hotDealProduct: HotDealProduct,
    onAddClick: () -> Unit
) {

        Column(
            modifier = Modifier
                .width(170.dp)
                .padding(bottom = 4.dp)
        )  {

            // Image Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .aspectRatio(1f), // Ensures the Box maintains a square aspect ratio
            ) {
                // Background Image
                Image(
                    painter = painterResource(id = hotDealProduct.imageResId),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Discount Badge
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd) // Place the badge at the top-right
                        .background(red, shape = RoundedCornerShape(bottomStart = 12.dp))
                        .padding(8.dp)
                ) {
                    Text(
                        text = hotDealProduct.discount,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Add Button - Place it at the bottom-right of the image
                    IconButton(
                        onClick = onAddClick,
                        modifier = Modifier
                            .align(Alignment.BottomEnd) // Place the button at the bottom-right
                            .size(32.dp) // Circular button size
                            .clip(CircleShape) // Ensure it's circular
                            .background(Color.LightGray) // Background color
                            .padding(4.dp) // Padding for the icon
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = red // Icon color
                        )
                    }
            }

            // Product Details
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, top = 6.dp)
            ) {
                Text(
                    text = hotDealProduct.name,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "₹${hotDealProduct.price}/${hotDealProduct.quantity}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
}



