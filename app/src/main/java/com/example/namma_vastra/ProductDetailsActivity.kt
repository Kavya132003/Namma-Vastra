package com.example.namma_vastra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product_details)

        val detailImage =
            findViewById<ImageView>(R.id.detailImage)

        val detailName =
            findViewById<TextView>(R.id.detailName)

        val detailPrice =
            findViewById<TextView>(R.id.detailPrice)

        val addToCartButton =
            findViewById<Button>(R.id.buyNowButton)

        val wishlistButton =
            findViewById<Button>(R.id.wishlistButton)

        val name = intent.getStringExtra("name") ?: ""

        val price = intent.getStringExtra("price") ?: ""

        val image = intent.getStringExtra("image") ?: ""

        detailName.text = name

        detailPrice.text = price

        Glide.with(this)
            .load(image)
            .into(detailImage)

        addToCartButton.setOnClickListener {

            val product = Product(
                name,
                price,
                image,
                1
            )

            CartManager.addToCart(product)

            Toast.makeText(
                this,
                "Added to Cart",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(
                Intent(
                    this,
                    CartActivity::class.java
                )
            )
        }

        wishlistButton.setOnClickListener {

            val product = Product(
                name,
                price,
                image,
                1
            )

            WishlistManager.addToWishlist(product)

            Toast.makeText(
                this,
                "Added To Wishlist",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(
                Intent(
                    this,
                    WishlistActivity::class.java
                )
            )
        }
    }
}