package com.example.namma_vastra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.adapters.ProductAdapter
import com.example.namma_vastra.models.Product

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val productList = listOf(

            Product("Traditional Ilkal Saree", "₹2500"),

            Product("Molakalmuru Silk Saree", "₹4500"),

            Product("Handloom Cotton Saree", "₹1800"),

            Product("Bridal Silk Saree", "₹6500")

        )

        val adapter = ProductAdapter(productList)

        recyclerView.adapter = adapter
    }
}