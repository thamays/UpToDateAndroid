package com.thamays.uptodateandroid.unit_04.navigate2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme

class NavigateActivityV2 : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpToDateAndroidTheme {
                LunchTrayApp()
            }
        }
    }
}
