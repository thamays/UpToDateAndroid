package com.thamays.uptodateandroid

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme
import com.thamays.uptodateandroid.unit_02.TipTimeLayout
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_ip() {
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        composeTestRule.setContent {
            UpToDateAndroidTheme {
                TipTimeLayout()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found.")
    }
}
