package com.example.namma_vastra

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.adapters.SellerOrderAdapter
import com.google.firebase.firestore.FirebaseFirestore

class SellerOrderManagementActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderList: ArrayList<Order>
    private lateinit var adapter: SellerOrderAdapter
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_seller_order_management)

        firestore = FirebaseFirestore.getInstance()

        recyclerView = findViewById(R.id.sellerOrdersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        orderList = ArrayList()

        adapter = SellerOrderAdapter(orderList, ::updateOrderStatus)
        recyclerView.adapter = adapter

        loadOrders()
    }

    private fun loadOrders() {

        firestore.collection("orders")
            .addSnapshotListener { snapshots, error ->

                if (error != null) {
                    Toast.makeText(
                        this,
                        "Failed to load orders",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@addSnapshotListener
                }

                if (snapshots == null) return@addSnapshotListener

                orderList.clear()

                for (doc in snapshots.documents) {

                    val order = doc.toObject(Order::class.java)

                    if (order != null) {
                        orderList.add(order)
                    }
                }

                adapter.notifyDataSetChanged()
            }
    }

    private fun updateOrderStatus(orderId: String, newStatus: String) {

        firestore.collection("orders")
            .document(orderId)
            .update("status", newStatus)
            .addOnSuccessListener {

                Toast.makeText(
                    this,
                    "Order updated to $newStatus",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener {

                Toast.makeText(
                    this,
                    "Status update failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}