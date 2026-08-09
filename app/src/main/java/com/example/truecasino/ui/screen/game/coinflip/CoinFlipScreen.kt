package com.example.truecasino.ui.screen.game.coinflip

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
fun CoinFlipScreen(toLobby: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "CoinFlip"
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
private fun CoinFlipScreenPrev() {
    CoinFlipScreen()
}