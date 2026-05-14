package com.example.namma_vastra

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class AddProductActivity : AppCompatActivity() {

    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_product)

        firestore = FirebaseFirestore.getInstance()

        val nameInput =
            findViewById<EditText>(R.id.productNameInput)

        val priceInput =
            findViewById<EditText>(R.id.productPriceInput)

        val imageInput =
            findViewById<EditText>(R.id.productImageInput)

        val uploadButton =
            findViewById<Button>(R.id.uploadButton)

        uploadButton.setOnClickListener {

            val name =
                nameInput.text.toString()

            val price =
                priceInput.text.toString()

            val image =
                imageInput.text.toString()

            if (
                name.isEmpty() ||
                price.isEmpty() ||
                image.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val product = Product(
                    name,
                    "₹$price",
                    image,
                    1
                )

                firestore.collection("products")
                    .add(product)
                    .addOnSuccessListener {

                        Toast.makeText(
                            this,
                            "Product Uploaded",
                            Toast.LENGTH_SHORT
                        ).show()

                        finish()
                    }
            }
        }
    }
}