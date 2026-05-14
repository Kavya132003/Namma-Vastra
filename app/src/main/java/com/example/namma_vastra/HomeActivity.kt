package com.example.namma_vastra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.adapters.ProductAdapter
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Locale

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    lateinit var productList: ArrayList<Product>

    lateinit var filteredList: ArrayList<Product>

    lateinit var adapter: ProductAdapter

    lateinit var firestore: FirebaseFirestore

    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        recyclerView =
            findViewById(R.id.recyclerViewProducts)

        searchView =
            findViewById(R.id.searchView)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        productList = ArrayList()

        filteredList = ArrayList()

        adapter = ProductAdapter(filteredList)

        recyclerView.adapter = adapter

        firestore = FirebaseFirestore.getInstance()

        loadProducts()

        setupSearch()
    }

    private fun loadProducts() {

        firestore.collection("products")
            .get()
            .addOnSuccessListener { documents ->

                productList.clear()

                filteredList.clear()

                for (document in documents) {

                    val product =
                        document.toObject(Product::class.java)

                    productList.add(product)

                    filteredList.add(product)
                }

                adapter.notifyDataSetChanged()
            }
    }

    private fun setupSearch() {

        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    filterProducts(newText)

                    return true
                }
            }
        )
    }

    private fun filterProducts(query: String?) {

        filteredList.clear()

        if (query.isNullOrEmpty()) {

            filteredList.addAll(productList)

        } else {

            val searchText =
                query.lowercase(Locale.getDefault())

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
}