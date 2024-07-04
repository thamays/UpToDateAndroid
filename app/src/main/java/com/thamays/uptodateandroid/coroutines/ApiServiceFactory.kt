package com.thamays.uptodateandroid.coroutines

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceFactory {
    fun create(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Replace with your API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
