package com.example.namma_vastra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.adapters.OrderAdapter
import com.google.firebase.firestore.FirebaseFirestore

class OrderHistoryActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    lateinit var orderList: ArrayList<Order>

    lateinit var adapter: OrderAdapter

    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_order_history)

        recyclerView =
            findViewById(R.id.ordersRecyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        orderList = ArrayList()

        adapter = OrderAdapter(orderList)

        recyclerView.adapter = adapter

        firestore = FirebaseFirestore.getInstance()

        loadOrders()
    }

    private fun loadOrders() {

        firestore.collection("orders")
            .get()
            .addOnSuccessListener { documents ->

                orderList.clear()

                for (document in documents) {

                    val order =
                        document.toObject(Order::class.java)

                    orderList.add(order)
                }

                adapter.notifyDataSetChanged()
            }
    }
}