package com.thamays.uptodateandroid.unit_04.navigate.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.thamays.uptodateandroid.R
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme

/**
 * Composable that displays formatted [price] that will be formatted and displayed on screen
 */
@Composable
fun FormattedPriceLabel(subtotal: String, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.subtotal_price, subtotal),
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall
    )
}

@Preview(showBackground = true)
@Composable
fun FormattedPriceLabelPreview() {
    UpToDateAndroidTheme {
        FormattedPriceLabel(subtotal = "300")
    }
}
