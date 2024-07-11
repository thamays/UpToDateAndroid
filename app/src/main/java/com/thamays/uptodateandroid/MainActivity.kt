package com.thamays.uptodateandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpToDateAndroidTheme {

            }
        }
    }
}
