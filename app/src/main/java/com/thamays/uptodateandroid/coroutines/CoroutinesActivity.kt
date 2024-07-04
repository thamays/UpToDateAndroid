package com.thamays.uptodateandroid.coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme

class CoroutinesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpToDateAndroidTheme {
                MyScreen() // MyScreen is now self-contained
            }
        }
    }
}
