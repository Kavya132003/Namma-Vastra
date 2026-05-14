package com.example.namma_vastra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_checkout)

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
}