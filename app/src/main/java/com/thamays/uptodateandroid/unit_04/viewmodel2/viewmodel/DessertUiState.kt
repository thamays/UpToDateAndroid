package com.thamays.uptodateandroid.unit_04.viewmodel2.viewmodel

import com.thamays.uptodateandroid.unit_04.viewmodel2.data.Datasource
import com.thamays.uptodateandroid.unit_04.viewmodel2.model.Dessert

data class DessertUiState(
    var currentDessertIndex: Int = 0,
    var currentDessert: Dessert = Datasource.dessertList.first(),
    var dessertSold: Int = 0,
    val totalRevenue: Int = 0
)
