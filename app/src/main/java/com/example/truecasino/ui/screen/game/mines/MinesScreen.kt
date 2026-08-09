package com.example.truecasino.ui.screen.game.mines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MinesScreen(toLobby: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "Mines"
        )
        Button(
            onClick = toLobby
        ) {
            Text(
                text = "Назад"
            )
        }
    }
}

@Preview
@Composable
private fun MinesScreenPrev() {
    MinesScreen()
}