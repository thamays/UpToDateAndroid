package com.thamays.uptodateandroid.coroutines

import retrofit2.http.GET

interface ApiService {
    @GET("items") // Replace with your API endpoint
    suspend fun getItems(): List<Item>
}
