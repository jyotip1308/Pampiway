package com.example.pampiway.utility

import com.example.pampiway.R

data class RatingFood(
    val name: String,
    val price: String,
    val rating: Int,
    val ratingsCount: String,
    val description: String,
    val imageResId: Int
)


data class Menu(
    val imageResId: Int,
    val name: String
)

data class Restaurant(
    val imageResId: Int,
    val name: String,
    val cuisine: String,
    val rating: Double,
    val distance: String,
    val time: String
)

data class PopularRestaurant(
    val imageResId: Int,
    val name: String,
    val description: String,
    val distance: String,
    val deliveryTime: String,
    val rating: String
)

data class DiscountMenu(
    val name: String,
    val originalPrice: String,
    val discountPrice: String,
    val discountPercent: String,
    val rating: Int,
    val ratingsCount: String,
    val description: String,
    val imageResId: Int
)

data class FeaturedItem(
    val imageResId: Int,
    val title: String,
    val price: Int
)

