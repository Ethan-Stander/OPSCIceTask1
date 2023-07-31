package com.example.trumpdumpapi

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.net.URLEncoder
import okhttp3.logging.HttpLoggingInterceptor


class ApiService {
    companion object {
        suspend fun getQuotes(query: String): List<Quote> = withContext(Dispatchers.IO) {
            val encodedQuery = URLEncoder.encode(query, "UTF-8")
            val url = "https://www.tronalddump.io/search/quote?query=$encodedQuery" // Encoded URL
            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY // This will log request and response details
                })
                .build()
            val request = Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/hal+json")
                .addHeader("X-RapidAPI-Key", "90dd79b286msh48e9e872c9d1588p1c8bedjsn6fa20326c908")
                .addHeader("X-RapidAPI-Host", "matchilling-tronald-dump-v1.p.rapidapi.com")
                .build()

            try {
                val response: Response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val jsonResponse = response.body?.string()
                    val quoteResponse: QuoteResponse = Gson().fromJson(jsonResponse, QuoteResponse::class.java)
                    return@withContext quoteResponse._embedded.quotes // Return the list of quotes
                } else {
                    emptyList() // Return an empty list if there are no quotes or an error occurs
                }
            } catch (e: IOException) {
                emptyList() // Return an empty list if an exception occurs
            }
        }

    }
}