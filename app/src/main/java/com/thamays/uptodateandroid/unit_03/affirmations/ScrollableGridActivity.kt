package com.thamays.uptodateandroid.unit_03.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thamays.uptodateandroid.R
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme
import com.thamays.uptodateandroid.unit_03.affirmations.data.Datasource
import com.thamays.uptodateandroid.unit_03.affirmations.model.Topic

class ScrollableGridActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UpToDateAndroidTheme {
                TopicApp()
            }
        }
    }
}

@Composable
fun TopicApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets
                    .safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),

                end = WindowInsets
                    .safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),
            ),
        color = MaterialTheme.colorScheme.background
    ) {
        TopicGrid(
            topics = Datasource.topics,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_small),
                top = dimensionResource(R.dimen.padding_small),
                end = dimensionResource(R.dimen.padding_small),
            )
        )
    }
}

@Preview
@Composable
fun TopicAppPreview() {
    TopicApp()
}

@Composable
fun TopicGrid(
    topics: List<Topic>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(topics) { topic ->
            TopicCard(
                topic = topic
            )
        }
    }
}

@Preview
@Composable
private fun TopicGridPreview() {
    TopicGrid(topics = Datasource.topics)
}

@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(
                    id = topic.stringResourceId
                ),
                modifier = modifier
                    .width(68.dp)
                    .height(68.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Column(modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
                Text(
                    text = LocalContext.current.getString(topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(modifier = modifier.padding(top = 8.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        tint = Color.Black,
                        contentDescription = "Grain Icon"
                    )
                    Text(
                        text = topic.count.toString(),
                        modifier = modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TopicCardPreview() {
    TopicCard(topic = Datasource.topics[0])
}
