package com.thamays.uptodateandroid.unit_05.internet.network

import retrofit2.http.GET

interface MarsApiService {

    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
