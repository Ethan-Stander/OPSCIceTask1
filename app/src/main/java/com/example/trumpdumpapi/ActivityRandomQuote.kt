package com.example.trumpdumpapi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.trumpdumpapi.ApiService.Companion.getQuotes
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class ActivityRandomQuote : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_quote)

        supportActionBar?.hide()


        val imgMenu = findViewById<ImageView>(R.id.imgMenuRandomQuote)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout_randomquote)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_about -> {
                    // Handle click for About item
                    val intent = Intent(this, AcivityAboutUs::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    true
                }


                R.id.nav_welcome -> {
                    val intent = Intent(this, WelcomeActivity::class.java)
                    startActivity(intent)

                    true
                }

                R.id.nav_random -> {
                    val intent = Intent(this, ActivityRandomQuote::class.java)
                    startActivity(intent)

                    true
                }

                // Handle other navigation items as needed


                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    true
                }

                R.id.nav_exit->
                {
                    finishAffinity()
                    true

                }

                else -> false
            }
        }

        val button = findViewById<Button>(R.id.btnRandomQuoteGuy)

        button.setOnClickListener {
            // Launch a coroutine
            CoroutineScope(Dispatchers.Main).launch {
                val quotes =
                    getQuotes("Obama") // Replace "your_query_here" with your actual query

                if (quotes.isNotEmpty()) {
                    val randomQuote = quotes[Random.nextInt(quotes.size)]

                    val tvQuote = findViewById<TextView>(R.id.tvQuote)
                    tvQuote.text = randomQuote.value

                    // Now you have a random quote object in the variable randomQuote
                } else {
                    // Handle the case when no quotes are available
                }
            }


        }
    }
}