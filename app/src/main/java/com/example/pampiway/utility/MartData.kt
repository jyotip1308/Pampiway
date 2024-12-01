package com.example.pampiway.utility

data class Product(
    val name: String,
    val imageResId: Int
)

data class HotDealProduct(
    val name: String,
    val price: String,
    val quantity: String,
    val imageResId: Int,
    val discount: String
)

data class MartCartProduct(
    val name: String,
    val price: String,
    val imageResId: Int,
    var quantity: Int = 0
)