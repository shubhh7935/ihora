package com.example.ihora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ihora.R.*
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)


        val username = findViewById<EditText>(id.username)
        val password = findViewById<EditText>(id.password)
        val loginButton = findViewById<Button>(id.login_btn)
        val registerButton = findViewById<Button>(id.register_btn)

        val correctUsername = "user"
        val correctPassword = "user123"

        // Handle login button click
        loginButton.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()

            // You can add actual login logic here
            if (username == correctUsername && password == correctPassword) {
                val intent = Intent(this, LanguageSelectionActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle register button click
        registerButton.setOnClickListener {
            // You can add actual registration logic here
            Toast.makeText(this, "Registration Clicked!", Toast.LENGTH_SHORT).show()
        }

        val languageSelected = intent.getStringExtra("LANGUAGE_SELECTED")
        if (languageSelected != null) {
            Toast.makeText(this, "Language: $languageSelected", Toast.LENGTH_SHORT).show()
        }
    }
}
