package com.thamays.uptodateandroid.unit_04.viewmodel.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thamays.uptodateandroid.R
import com.thamays.uptodateandroid.ui.theme.UpToDateAndroidTheme
import com.thamays.uptodateandroid.unit_04.viewmodel.ui.viewmodel.GameViewModel

@Composable
fun GameScreen(gameViewModel: GameViewModel = viewModel()) {
    val gameUiState by gameViewModel.uiState.collectAsState()

    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    Log.i("RECOMPOSITION - ", "----------")
    Log.i("RECOMPOSITION - ", "GameScreen")

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = typography.titleLarge,
        )
        GameLayout(
            wordCount = gameUiState.currentWordCount,
            isGuessWrong = gameUiState.isGuessedWordWrong,
            userGuess = gameViewModel.userGuess,
            onUserGuessChanged = { gameViewModel.updateUserGuess(it) },
            onKeyboardDone = { gameViewModel.checkUserGuess() },
            currentScrambledWord = gameUiState.currentScrambledWord,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(mediumPadding)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(mediumPadding),
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { gameViewModel.checkUserGuess() }
            ) {
                Text(
                    text = stringResource(R.string.submit),
                    fontSize = 16.sp
                )
            }

            OutlinedButton(
                onClick = { gameViewModel.skipWord() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.skip),
                    fontSize = 16.sp
                )
            }
        }

        GameStatus(score = gameUiState.score, modifier = Modifier.padding(20.dp))
    }

    if (gameUiState.isGameOver) {
        FinalScoreDialog(score = gameUiState.score, onPlayAgain = { gameViewModel.resetGame() })
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    UpToDateAndroidTheme {
        GameScreen()
    }
}

//@Composable
//fun GameStatus(score: Int, modifier: Modifier = Modifier) {
//    Card(
//        modifier = modifier
//    ) {
//        Text(
//            text = stringResource(R.string.score, score),
//            style = typography.headlineMedium,
//            modifier = Modifier.padding(8.dp)
//        )
//    }
//}

//@Composable
//fun GameLayout(modifier: Modifier = Modifier) {
//    val mediumPadding = dimensionResource(R.dimen.padding_medium)
//
//    Card(
//        modifier = modifier,
//        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
//    ) {
//        Column(
//            verticalArrangement = Arrangement.spacedBy(mediumPadding),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.padding(mediumPadding)
//        ) {
//            Text(
//                modifier = Modifier
//                    .clip(shapes.medium)
//                    .background(colorScheme.surfaceTint)
//                    .padding(horizontal = 10.dp, vertical = 4.dp)
//                    .align(alignment = Alignment.End),
//                text = stringResource(R.string.word_count, 0),
//                style = typography.titleMedium,
//                color = colorScheme.onPrimary
//            )
//            Text(
//                text = "scrambleun",
//                style = typography.displayMedium
//            )
//            Text(
//                text = stringResource(R.string.instructions),
//                textAlign = TextAlign.Center,
//                style = typography.titleMedium
//            )
//            OutlinedTextField(
//                value = "",
//                singleLine = true,
//                shape = shapes.large,
//                modifier = Modifier.fillMaxWidth(),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = colorScheme.surface,
//                    unfocusedContainerColor = colorScheme.surface,
//                    disabledContainerColor = colorScheme.surface,
//                ),
//                onValueChange = { },
//                label = { Text(stringResource(R.string.enter_your_word)) },
//                isError = false,
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    imeAction = ImeAction.Done
//                ),
//                keyboardActions = KeyboardActions(
//                    onDone = { }
//                )
//            )
//        }
//    }
//}

/*
 * Creates and shows an AlertDialog with final score.
 */
//@Composable
//private fun FinalScoreDialog(
//    score: Int,
//    onPlayAgain: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    val activity = (LocalContext.current as Activity)
//
//    AlertDialog(
//        onDismissRequest = {
//            // Dismiss the dialog when the user clicks outside the dialog or on the back
//            // button. If you want to disable that functionality, simply use an empty
//            // onCloseRequest.
//        },
//        title = { Text(text = stringResource(R.string.congratulations)) },
//        text = { Text(text = stringResource(R.string.you_scored, score)) },
//        modifier = modifier,
//        dismissButton = {
//            TextButton(
//                onClick = {
//                    activity.finish()
//                }
//            ) {
//                Text(text = stringResource(R.string.exit))
//            }
//        },
//        confirmButton = {
//            TextButton(onClick = onPlayAgain) {
//                Text(text = stringResource(R.string.play_again))
//            }
//        }
//    )
//}
