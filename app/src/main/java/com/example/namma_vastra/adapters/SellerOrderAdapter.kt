package com.example.namma_vastra.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.namma_vastra.Order
import com.example.namma_vastra.R
import com.google.firebase.firestore.FirebaseFirestore

class SellerOrderAdapter(
    private val orderList: ArrayList<Order>,
    private val updateStatus: (String, String) -> Unit
) : RecyclerView.Adapter<SellerOrderAdapter.SellerOrderViewHolder>() {

    class SellerOrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val customerName: TextView = itemView.findViewById(R.id.sellerOrderCustomer)
        val products: TextView = itemView.findViewById(R.id.sellerOrderProducts)
        val total: TextView = itemView.findViewById(R.id.sellerOrderTotal)
        val status: TextView = itemView.findViewById(R.id.sellerOrderStatus)

        val confirmBtn: Button = itemView.findViewById(R.id.btnConfirm)
        val shipBtn: Button = itemView.findViewById(R.id.btnShip)
        val deliverBtn: Button = itemView.findViewById(R.id.btnDeliver)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellerOrderViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_seller_order, parent, false)

        return SellerOrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SellerOrderViewHolder, position: Int) {

        val order = orderList[position]

        holder.customerName.text = order.customerName
        holder.products.text = "Products: ${order.products}"
        holder.total.text = "Total: ${order.totalPrice}"
        holder.status.text = order.status

        // -------------------------------
        // SAFETY CHECK (IMPORTANT)
        // -------------------------------
        val orderId = order.orderId

        // -------------------------------
        // STATUS UPDATE ACTIONS
        // -------------------------------
        holder.confirmBtn.setOnClickListener {
            if (orderId.isNotEmpty()) {
                updateStatus(orderId, "CONFIRMED")
            }
        }

        holder.shipBtn.setOnClickListener {
            if (orderId.isNotEmpty()) {
                updateStatus(orderId, "SHIPPED")
            }
        }

        holder.deliverBtn.setOnClickListener {
            if (orderId.isNotEmpty()) {
                updateStatus(orderId, "DELIVERED")
            }
        }

        // -------------------------------
        // BUTTON FLOW CONTROL (LIFECYCLE LOGIC)
        // -------------------------------
        when (order.status) {

            "PLACED" -> {
                holder.confirmBtn.isEnabled = true
                holder.shipBtn.isEnabled = false
                holder.deliverBtn.isEnabled = false
            }

            "CONFIRMED" -> {
                holder.confirmBtn.isEnabled = false
                holder.shipBtn.isEnabled = true
                holder.deliverBtn.isEnabled = false
            }

            "SHIPPED" -> {
                holder.confirmBtn.isEnabled = false
                holder.shipBtn.isEnabled = false
                holder.deliverBtn.isEnabled = true
            }

            "DELIVERED" -> {
                holder.confirmBtn.isEnabled = false
                holder.shipBtn.isEnabled = false
                holder.deliverBtn.isEnabled = false
            }
        }

        // -------------------------------
        // STATUS COLOR INTELLIGENCE LAYER
        // -------------------------------
        val color = when (order.status) {

            "PLACED" -> "#FF9800"
            "CONFIRMED" -> "#2196F3"
            "SHIPPED" -> "#9C27B0"
            "DELIVERED" -> "#4CAF50"
            else -> "#9E9E9E"
        }

        holder.status.setBackgroundColor(Color.parseColor(color))
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}