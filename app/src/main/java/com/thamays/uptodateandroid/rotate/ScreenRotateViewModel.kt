package com.thamays.uptodateandroid.rotate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ScreenRotateViewModel : ViewModel() {
    private val _items = MutableStateFlow<List<String>>(emptyList())
    val items: StateFlow<List<String>> = _items

    private val _liveData = MutableLiveData<List<String>>(emptyList())
    val liveData: LiveData<List<String>> = _liveData

    init {
        // Initialize ViewModel data, fetch from repository, etc.
        fetchItems() // Example: Fetch initial items from a repository
    }

    private fun fetchItems() {
        viewModelScope.launch {
            Log.i("ROTATE: ", "fetchItems: ")
            val fetchedData = listOf("Item 1", "Item 2", "Item 3")
            _items.value = fetchedData
            _liveData.value = fetchedData
        }
    }
}
