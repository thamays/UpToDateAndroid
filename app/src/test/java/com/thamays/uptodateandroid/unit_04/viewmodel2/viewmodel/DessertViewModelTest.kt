package com.thamays.uptodateandroid.unit_04.viewmodel2.viewmodel

import com.thamays.uptodateandroid.R
import com.thamays.uptodateandroid.unit_04.viewmodel2.data.Datasource
import org.junit.Assert.assertEquals
import org.junit.Test

class DessertViewModelTest {
    private val viewModel = DessertViewModel()

    @Test
    fun dessertViewModel_DessertClicked_IncreaseRevenue() {
        viewModel.dessertSold()
        val currentUiState: DessertUiState = viewModel.uiState.value

        assertEquals(1, currentUiState.dessertSold)
        assertEquals(5, currentUiState.totalRevenue)
        assertEquals(R.drawable.cupcake, currentUiState.currentDessert.imageId)
    }
}
