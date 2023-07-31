package com.example.trumpdumpapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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