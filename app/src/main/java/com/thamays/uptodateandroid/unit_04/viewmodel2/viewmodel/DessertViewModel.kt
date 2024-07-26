package com.thamays.uptodateandroid.unit_04.viewmodel2.viewmodel

import androidx.lifecycle.ViewModel
import com.thamays.uptodateandroid.unit_04.viewmodel2.data.Datasource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun dessertSold() {
        if (Datasource.dessertList.size > _uiState.value.currentDessertIndex) {
            _uiState.update { currentState ->
                var currentDessertIndex = _uiState.value.currentDessertIndex
                val currentDessert = Datasource.dessertList[currentDessertIndex]
                val dessertSold = _uiState.value.dessertSold.inc()

                if (dessertSold >= currentDessert.startProductionAmount) {
                    currentDessertIndex++
                }

                currentState.copy(
                    currentDessertIndex = currentDessertIndex,
                    currentDessert = currentDessert,
                    dessertSold = dessertSold,
                    totalRevenue = _uiState.value.totalRevenue + currentDessert.price
                )
            }
        }
    }
}
