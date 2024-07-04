package com.thamays.uptodateandroid.coroutines

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyScreen(viewModel: ItemViewModel = viewModel(factory = ItemViewModelFactory(Repository(ApiServiceFactory.create())))) {
    val items by viewModel.items.collectAsState()

    Column {
        LazyColumn {
            items(items.size) { i ->
                Text(text = items[i].name)
            }
        }
    }
}
