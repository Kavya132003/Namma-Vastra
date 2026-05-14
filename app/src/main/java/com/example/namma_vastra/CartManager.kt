package com.example.namma_vastra

object CartManager {

    val cartItems = ArrayList<Product>()

    fun addToCart(product: Product) {

        cartItems.add(product)
    }
}