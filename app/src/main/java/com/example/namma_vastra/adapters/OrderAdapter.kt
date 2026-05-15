package com.example.namma_vastra.adapters

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.Order
import com.example.namma_vastra.OrderDetailActivity
import com.example.namma_vastra.R

class OrderAdapter(
    private val orderList: ArrayList<Order>
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val customerName: TextView = itemView.findViewById(R.id.orderCustomer)
        val products: TextView = itemView.findViewById(R.id.orderProducts)
        val total: TextView = itemView.findViewById(R.id.orderTotal)
        val status: TextView = itemView.findViewById(R.id.orderStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)

        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {

        val order = orderList[position]

        holder.customerName.text = order.customerName
        holder.products.text = "Products: ${order.products}"
        holder.total.text = "Total: ${order.totalPrice}"
        holder.status.text = order.status

        // -------------------------------
        // STATUS INTELLIGENCE LAYER
        // -------------------------------
        val color = when (order.status) {

            "PLACED" -> "#FF9800"          // Orange
            "CONFIRMED" -> "#2196F3"       // Blue
            "SHIPPED" -> "#9C27B0"         // Purple
            "OUT_FOR_DELIVERY" -> "#009688" // Teal
            "DELIVERED" -> "#4CAF50"        // Green

            else -> "#9E9E9E"              // Grey
        }

        holder.status.setBackgroundColor(Color.parseColor(color))

        // -------------------------------
        // CLICK → ORDER DETAIL VIEW
        // -------------------------------
        holder.itemView.setOnClickListener {

            val context = holder.itemView.context

            val intent = Intent(context, OrderDetailActivity::class.java).apply {
                putExtra("orderId", order.orderId)
                putExtra("customerName", order.customerName)
                putExtra("products", order.products)
                putExtra("totalPrice", order.totalPrice)
                putExtra("status", order.status)
            }

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}