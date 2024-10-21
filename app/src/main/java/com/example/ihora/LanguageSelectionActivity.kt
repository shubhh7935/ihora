package com.example.ihora

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class LanguageSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_selection)

        val englishButton = findViewById<Button>(R.id.englishButton)
        val spanishButton = findViewById<Button>(R.id.spanishButton)
        val frenchButton = findViewById<Button>(R.id.frenchButton)

        englishButton.setOnClickListener {
            changeLanguage("en")
        }

        spanishButton.setOnClickListener {
            changeLanguage("es")
        }

        frenchButton.setOnClickListener {
            changeLanguage("fr")
        }
    }

    // Function to change the app's language
    private fun changeLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)

        // Update the configuration for the app
        resources.updateConfiguration(config, resources.displayMetrics)

        // Show a toast message to confirm language selection
        Toast.makeText(this, "Language changed to ${locale.displayLanguage}", Toast.LENGTH_SHORT).show()

        // Navigate to HomeActivity after changing language
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
