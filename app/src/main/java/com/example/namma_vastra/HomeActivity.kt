package com.example.namma_vastra

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.adapters.ProductAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Locale

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productList: ArrayList<Product>
    private lateinit var filteredList: ArrayList<Product>
    private lateinit var adapter: ProductAdapter
    private lateinit var firestore: FirebaseFirestore
    private lateinit var searchView: SearchView
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerViewProducts)
        searchView = findViewById(R.id.searchView)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        recyclerView.layoutManager = LinearLayoutManager(this)

        productList = ArrayList()
        filteredList = ArrayList()

        adapter = ProductAdapter(filteredList)
        recyclerView.adapter = adapter

        firestore = FirebaseFirestore.getInstance()

        loadProducts()
        setupSearch()
        setupBottomNavigation()
    }

    private fun loadProducts() {

        firestore.collection("products")
            .get()
            .addOnSuccessListener { documents ->

                productList.clear()
                filteredList.clear()

                for (document in documents) {

                    val product = document.toObject(Product::class.java)

                    productList.add(product)
                    filteredList.add(product)
                }

                adapter.notifyDataSetChanged()
            }
    }

    private fun setupSearch() {

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterProducts(newText)
                return true
            }
        })
    }

    private fun filterProducts(query: String?) {

        filteredList.clear()

        if (query.isNullOrEmpty()) {

            filteredList.addAll(productList)

        } else {

            val searchText = query.lowercase(Locale.getDefault())

            for (product in productList) {

                if (product.name.lowercase(Locale.getDefault())
                        .contains(searchText)
                ) {
                    filteredList.add(product)
                }
            }
        }

        adapter.notifyDataSetChanged()
    }

    private fun setupBottomNavigation() {

        bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.nav_home -> {
                    true
                }

                R.id.nav_wishlist -> {
                    startActivity(
                        Intent(this, WishlistActivity::class.java)
                    )
                    true
                }

                R.id.nav_cart -> {
                    startActivity(
                        Intent(this, CartActivity::class.java)
                    )
                    true
                }

                R.id.nav_orders -> {
                    startActivity(
                        Intent(this, OrderHistoryActivity::class.java)
                    )
                    true
                }

                R.id.nav_seller -> {
                    startActivity(
                        Intent(this, SellerDashboardActivity::class.java)
                    )
                    true
                }

                else -> false
            }
        }
    }
}