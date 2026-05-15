package com.example.namma_vastra

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_order_detail)

        val status = intent.getStringExtra("status") ?: "PLACED"

        val tvPlaced = findViewById<TextView>(R.id.tvPlaced)
        val tvConfirmed = findViewById<TextView>(R.id.tvConfirmed)
        val tvShipped = findViewById<TextView>(R.id.tvShipped)
        val tvDelivered = findViewById<TextView>(R.id.tvDelivered)

        when (status) {

            "PLACED" -> {
                tvPlaced.setTextColor(Color.GREEN)
            }

            "CONFIRMED" -> {
                tvPlaced.setTextColor(Color.GREEN)
                tvConfirmed.setTextColor(Color.BLUE)
            }

            "SHIPPED" -> {
                tvPlaced.setTextColor(Color.GREEN)
                tvConfirmed.setTextColor(Color.BLUE)
                tvShipped.setTextColor(Color.MAGENTA)
            }

            "DELIVERED" -> {
                tvPlaced.setTextColor(Color.GREEN)
                tvConfirmed.setTextColor(Color.BLUE)
                tvShipped.setTextColor(Color.MAGENTA)
                tvDelivered.setTextColor(Color.parseColor("#4CAF50"))
            }
        }
    }
}