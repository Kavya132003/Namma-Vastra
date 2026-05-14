package com.example.namma_vastra

object WishlistManager {

    val wishlistItems = ArrayList<Product>()

    fun addToWishlist(product: Product) {

        wishlistItems.add(product)
    }
}