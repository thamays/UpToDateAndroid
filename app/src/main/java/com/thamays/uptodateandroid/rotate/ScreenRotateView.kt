package com.thamays.uptodateandroid.rotate

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyApp() {
    val viewModel: ScreenRotateViewModel = viewModel()
    MyScreen(viewModel)
}

@Composable
fun MyScreen(viewModel: ScreenRotateViewModel) {
    // Observe StateFlow from ViewModel
    val items by viewModel.items.collectAsState()
    val liveData by viewModel.liveData.observeAsState(initial = emptyList())

    Log.v("ROTATE: ", "State Flow List Size: ${items.size}")
    Log.v("ROTATE: ", "Live Data List Size: ${liveData.size}")

    Column {
        items.forEach { item ->
            Text(text = "State Flow - $item")
        }
        liveData.forEach { item ->
            Text(text = "Live Data - $item")
        }
    }
}
