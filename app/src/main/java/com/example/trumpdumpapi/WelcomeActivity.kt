package com.example.trumpdumpapi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class WelcomeActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.hide()

        val imgMenu = findViewById<ImageView>(R.id.imgMenuWelcome)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout_welcome)
        val navView = findViewById<NavigationView>(R.id.nav_view)
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




    }


}