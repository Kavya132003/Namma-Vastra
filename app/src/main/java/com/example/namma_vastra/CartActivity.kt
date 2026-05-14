package com.example.namma_vastra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.adapters.CartAdapter

class CartActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    lateinit var totalPriceText: TextView

    lateinit var checkoutButton: Button

    lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cart)

        recyclerView =
            findViewById(R.id.cartRecyclerView)

        totalPriceText =
            findViewById(R.id.totalPriceText)

        checkoutButton =
            findViewById(R.id.checkoutButton)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        adapter =
            CartAdapter(CartManager.cartItems)

        recyclerView.adapter = adapter

        calculateTotal()

        checkoutButton.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CheckoutActivity::class.java
                )
            )
        }
    }

    private fun calculateTotal() {

        var total = 0

        for (product in CartManager.cartItems) {

            val price =
                product.price.replace("₹", "")
                    .toIntOrNull() ?: 0

            total += price * product.quantity
        }

        totalPriceText.text =
            "Total: ₹$total"
    }
}