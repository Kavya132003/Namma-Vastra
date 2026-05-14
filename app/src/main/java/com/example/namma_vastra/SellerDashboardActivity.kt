package com.example.namma_vastra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.adapters.SellerAdapter
import com.google.firebase.firestore.FirebaseFirestore

class SellerDashboardActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    lateinit var adapter: SellerAdapter

    lateinit var firestore: FirebaseFirestore

    lateinit var addProductButton: Button

    val productList = ArrayList<Product>()

    val documentIds = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_seller_dashboard)

        recyclerView =
            findViewById(R.id.sellerRecyclerView)

        addProductButton =
            findViewById(R.id.addProductButton)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        firestore = FirebaseFirestore.getInstance()

        adapter =
            SellerAdapter(
                productList,
                documentIds
            )

        recyclerView.adapter = adapter

        loadProducts()

        addProductButton.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AddProductActivity::class.java
                )
            )
        }
    }

    private fun loadProducts() {

        firestore.collection("products")
            .get()
            .addOnSuccessListener { documents ->

                productList.clear()

                documentIds.clear()

                for (document in documents) {

                    val product =
                        document.toObject(Product::class.java)

                    productList.add(product)

                    documentIds.add(document.id)
                }

                adapter.notifyDataSetChanged()
            }
    }
}