package com.thamays.uptodateandroid.unit_05.internet

import android.app.Application
import com.thamays.uptodateandroid.unit_05.internet.data.AppContainer
import com.thamays.uptodateandroid.unit_05.internet.data.DefaultAppContainer

class MarsPhotosApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
