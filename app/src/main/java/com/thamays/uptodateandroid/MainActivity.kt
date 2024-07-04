package com.thamays.uptodateandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpToDateAndroidTheme {
                BusinessCard(Modifier)
//                ComposeQuadrant(Modifier)
//                TaskManager(Modifier.fillMaxSize())
//                ComposeArticle(Modifier.fillMaxSize())
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    GreetingImage(
//                        message = stringResource(R.string.happy_birthday_text),
//                        from = stringResource(R.string.signature_text),
//                        modifier = Modifier.padding(8.dp)
//                    )
//                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .background(Color.DarkGray)
                    .padding(6.dp)
            )
            Text(
                text = "Thamays Ganesha",
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 6.dp, bottom = 6.dp)
            )
            Text(
                text = "Android Developer Extraordinaire",
                color = Color.Gray
            )
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Column {
                Icon(
                    Icons.Rounded.Call,
                    contentDescription = "Phone Icon",
                    modifier = Modifier.padding(6.dp)
                )
                Icon(
                    Icons.Rounded.Share,
                    contentDescription = "Share Icon",
                    modifier = Modifier.padding(6.dp)

                )
                Icon(
                    Icons.Rounded.Email,
                    contentDescription = "Phone Icon",
                    modifier = Modifier.padding(6.dp)

                )
            }
            Column {
                Text(
                    text = "+11 (123) 444 555 666",
                    modifier = Modifier.padding(6.dp)

                )
                Text(
                    text = "@Android Dev",
                    modifier = Modifier.padding(6.dp)

                )
                Text(
                    text = "abcd.as@gmail.com",
                    modifier = Modifier.padding(6.dp)

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    UpToDateAndroidTheme {
        BusinessCard()
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message, from = from, modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }

}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFEADDFF))
                        .padding(16.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Text composable",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        textAlign = TextAlign.Justify
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFD0BCFF))
                        .padding(16.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Image composable",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Creates a composable that lays out and draws a given Painter class object.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFB69DF8))
                        .padding(16.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Row composable",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "A layout composable that places its children in a horizontal sequence.",
                        textAlign = TextAlign.Justify
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFF6EDFF))
                        .padding(16.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Column composable",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "A layout composable that places its children in a vertical sequence.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ComposeQuadrantPreview() {
    UpToDateAndroidTheme {
        ComposeQuadrant()
    }
}

@Composable
fun TaskManager(modifier: Modifier = Modifier) {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_task_completed),
                contentDescription = "Task Completed Icon",
            )
            Text(
                text = stringResource(R.string.tasks_completed_title),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = 24.dp,
                    bottom = 8.dp
                )
            )
            Text(
                text = stringResource(R.string.tasks_completed_message),
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskManagerPreview(modifier: Modifier = Modifier) {
    UpToDateAndroidTheme {
        TaskManager()
    }
}

@Composable
fun ComposeArticle(modifier: Modifier = Modifier) {
    Surface {
        Column {
            Image(
                painter = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = "Compose Article Background",
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = stringResource(R.string.jetpack_titile),
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = stringResource(R.string.jetpack_description_1),
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = stringResource(R.string.jetpack_description_2),
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
        }

    }
}

@Preview(name = "Compose Article", showBackground = true)
@Composable
fun ComposeArticlePreview() {
    UpToDateAndroidTheme {
        ComposeArticle()
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    UpToDateAndroidTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text),
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Preview(name = "Column Arrangement", showBackground = true)
@Composable
fun MyColumn() {
    UpToDateAndroidTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "COLUMN 1",
                        modifier = Modifier
                            .background(Color.Cyan)
                            .padding(6.dp)
                    )
                    Text(
                        text = "COLUMN 2",
                        modifier = Modifier
                            .background(Color.Cyan)
                            .padding(6.dp)
                    )
                    Text(
                        text = "COLUMN 3",
                        modifier = Modifier
                            .background(Color.Cyan)
                            .padding(6.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "COLUMN 1",
                        modifier = Modifier
                            .background(Color.Cyan)
                            .padding(6.dp)
                    )
                    Text(
                        text = "COLUMN 2",
                        modifier = Modifier
                            .background(Color.Cyan)
                            .padding(6.dp)
                    )
                    Text(
                        text = "COLUMN 3",
                        modifier = Modifier
                            .background(Color.Cyan)
                            .padding(6.dp)
                    )
                }
                Text(
                    text = "ROW 3",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .padding(6.dp)
                )
                Text(
                    text = "ROW 4",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .padding(6.dp)
                )
            }
        }
    }
}
