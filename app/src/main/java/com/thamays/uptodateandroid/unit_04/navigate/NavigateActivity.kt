package com.thamays.uptodateandroid.unit_04.navigate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme

class NavigateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            UpToDateAndroidTheme {
                CupcakeApp()
            }
        }
    }
}
