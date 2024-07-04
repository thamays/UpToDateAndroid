package com.thamays.uptodateandroid.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Repository(private val apiService: ApiService) {
    suspend fun fetchItems(): List<Item> {
        return withContext(Dispatchers.IO) {
            delay(2000) // Simulate a network delay
//            apiService.getItems()

            val a = Item(3, "sss")
            val b = a.copy()
            listOf(Item(1, "Item 1"), Item(2, "Item 2"))
        }
    }
}
