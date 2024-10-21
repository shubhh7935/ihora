package com.example.ihora

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navigationView: NavigationView = findViewById(R.id.navigationView)

        findViewById<ImageButton>(R.id.menuButton).setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_about -> {
                    Toast.makeText(this, "About Selected", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_services -> {
                    Toast.makeText(this, "Services Selected", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_blog -> {
                    Toast.makeText(this, "Blog Selected", Toast.LENGTH_SHORT).show()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        findViewById<Button>(R.id.reservationButton).setOnClickListener {
            Toast.makeText(this, "Make Reservations Clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.contactUsButton).setOnClickListener {
            val contactIntent = Intent(this, ContactActivity::class.java)
            startActivity(contactIntent)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
