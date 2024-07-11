package com.thamays.uptodateandroid.unit_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thamays.uptodateandroid.R
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme

class UiAndStateActivityV2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UpToDateAndroidTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceLayout(data)
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(data: List<List<Int>>) {
    var currentView by remember {
        mutableIntStateOf(0)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            ArtworkWall(data[currentView][3])
        }
        Box(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(12.dp)
        ) {
            ArtworkDescriptor(
                data[currentView][0],
                data[currentView][1],
                data[currentView][2]
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box {
            DisplayController(
                { if (currentView > 0) currentView-- },
                { if (currentView < data.size - 1) currentView++ }
            )
        }
    }
}

@Composable
private fun DisplayController(
    onClickPre: () -> Unit,
    onClickNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = onClickPre, modifier = Modifier.width(150.dp)) {
            Text(text = "Previous")
        }
        Button(onClick = onClickNext, modifier = Modifier.width(150.dp)) {
            Text(text = "Next")
        }
    }
}

@Composable
private fun ArtworkDescriptor(
    @StringRes title: Int,
    @StringRes name: Int,
    @StringRes year: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = title),
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )
        Row {
            Text(
                text = stringResource(id = name),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = stringResource(id = year),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun ArtworkWall(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .shadow(elevation = 8.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(40.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    UpToDateAndroidTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ArtSpaceLayout(data)
        }
    }
}

val data = listOf(
    listOf(
        R.string.wallpaper_title_1,
        R.string.wallpaper_name_1,
        R.string.wallpaper_year_1,
        R.drawable.wallpaper_1
    ),
    listOf(
        R.string.wallpaper_title_2,
        R.string.wallpaper_name_2,
        R.string.wallpaper_year_2,
        R.drawable.wallpaper_2
    ),
    listOf(
        R.string.wallpaper_title_3,
        R.string.wallpaper_name_3,
        R.string.wallpaper_year_3,
        R.drawable.wallpaper_3
    )
)

