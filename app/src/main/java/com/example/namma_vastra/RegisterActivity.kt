package com.example.namma_vastra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
    }
}