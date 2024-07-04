package com.thamays.uptodateandroid.rotate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme

class ScreenRotateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("ROTATE: ", "-----------")
        Log.w("ROTATE: ", "onCreate")

        setContent {
            UpToDateAndroidTheme {
                MyApp()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("ROTATE: ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w("ROTATE: ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("ROTATE: ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("ROTATE: ", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("ROTATE: ", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("ROTATE: ", "onRestart")
    }
}
