package com.example.ihora

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // Back button action
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()  // Close current activity and go back to the previous activity
        }

        // Email button action
        findViewById<Button>(R.id.emailButton).setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:") // Only email apps should handle this
                putExtra(Intent.EXTRA_EMAIL, arrayOf("youremail@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Inquiry from the app")
            }
            startActivity(Intent.createChooser(emailIntent, "Send Email"))
        }

        // Call button action
        findViewById<Button>(R.id.callButton).setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+123456789") // Replace with your phone number
            }
            startActivity(callIntent)
        }
    }
}
