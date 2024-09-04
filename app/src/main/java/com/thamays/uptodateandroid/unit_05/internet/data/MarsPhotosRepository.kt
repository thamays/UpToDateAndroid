package com.thamays.uptodateandroid.unit_05.internet.data

import com.thamays.uptodateandroid.unit_05.internet.network.MarsApiService
import com.thamays.uptodateandroid.unit_05.internet.network.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getMarsPhoto(): List<MarsPhoto>
}

class NetworkMarsPhotoRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    override suspend fun getMarsPhoto(): List<MarsPhoto> = marsApiService.getPhotos()
}
