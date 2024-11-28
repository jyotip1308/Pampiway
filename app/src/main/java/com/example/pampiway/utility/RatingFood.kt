package com.example.pampiway.utility

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