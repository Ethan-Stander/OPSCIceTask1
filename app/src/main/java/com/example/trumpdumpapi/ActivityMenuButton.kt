package com.example.trumpdumpapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityMenuButton :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_button)

        supportActionBar?.hide()

        val button = findViewById<Button>(R.id.btnNext)
        button.setOnClickListener(
            {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            })
    }
}