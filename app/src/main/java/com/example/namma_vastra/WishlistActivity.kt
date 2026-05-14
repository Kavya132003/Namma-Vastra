package com.example.namma_vastra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.adapters.CartAdapter

class WishlistActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_wishlist)

        recyclerView =
            findViewById(R.id.wishlistRecyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        adapter =
            CartAdapter(WishlistManager.wishlistItems)

        recyclerView.adapter = adapter
    }
}