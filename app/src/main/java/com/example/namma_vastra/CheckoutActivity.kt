package com.example.namma_vastra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class CheckoutActivity : AppCompatActivity() {

    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_checkout)

        firestore = FirebaseFirestore.getInstance()

        val nameInput =
            findViewById<EditText>(R.id.nameInput)

        val addressInput =
            findViewById<EditText>(R.id.addressInput)

        val phoneInput =
            findViewById<EditText>(R.id.phoneInput)

        val placeOrderButton =
            findViewById<Button>(R.id.placeOrderButton)

        placeOrderButton.setOnClickListener {

            val name = nameInput.text.toString()

            val address = addressInput.text.toString()

            val phone = phoneInput.text.toString()

            if (
                name.isEmpty() ||
                address.isEmpty() ||
                phone.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all details",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                saveOrderToFirestore(
                    name,
                    address,
                    phone
                )
            }
        }
    }

    private fun saveOrderToFirestore(
        name: String,
        address: String,
        phone: String
    ) {

        var total = 0

        val productNames = StringBuilder()

        for (product in CartManager.cartItems) {

            val price =
                product.price.replace("₹", "")
                    .toIntOrNull() ?: 0

            total += price * product.quantity

            productNames.append(product.name)
                .append(", ")
        }

        val order = Order(
            customerName = name,
            address = address,
            phone = phone,
            totalPrice = "₹$total",
            products = productNames.toString()
        )

        firestore.collection("orders")
            .add(order)
            .addOnSuccessListener {

                Toast.makeText(
                    this,
                    "Order Placed Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                CartManager.cartItems.clear()

                startActivity(
                    Intent(
                        this,
                        OrderSuccessActivity::class.java
                    )
                )

                finish()
            }
    }
}