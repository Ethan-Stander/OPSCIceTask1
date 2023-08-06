package com.example.trumpdumpapi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //Navigation Drawer

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layoutaboutus)
        val imgMenu = findViewById<ImageView>(R.id.imgMenu)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.itemIconTintList = null
        imgMenu.setOnClickListener{
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



                R.id.nav_welcome ->
                {
                    val intent = Intent(this, WelcomeActivity::class .java)
                    startActivity(intent)

                    true
                }

                R.id.nav_random ->
                {
                    val intent = Intent(this, ActivityRandomQuote::class.java )
                    startActivity(intent)

                    true
                }

                // Handle other navigation items as needed



                R.id.nav_home ->
                {
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


        //home page
        val button = findViewById<Button>(R.id.btnSearch)

        button.setOnClickListener()
        {
            var bCheck = true;
            val searchbox = findViewById<TextView>(R.id.txtSearch)
            val display = findViewById<TextView>(R.id.txtView)

            if (searchbox.text.isEmpty()) {
                bCheck = false;
                Toast.makeText(this, "Please enter text!", Toast.LENGTH_SHORT).show()
            }


            if (bCheck) {
                CoroutineScope(Dispatchers.Main).launch {
                    val quotes: List<Quote?> = ApiService.getQuotes(searchbox.text.toString())

                    // Handle the fetched quotes inside the if block
                    if (quotes != null) {

                        val quotesText = quotes.joinToString("\n----------\n") { it?.value ?: "" }
                        display.text = quotesText



                        // Do something with the quotes
                    } else {
                        // Handle the case where the API call failed or returned no data
                    }
                }

            }

        }
    }
}