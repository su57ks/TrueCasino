package com.example.truecasino.ui.screen.lobby

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LobbyScreen(
    toCoinFlip: () -> Unit = {},
    toMines: () -> Unit = {},
    toRoulette: () -> Unit = {},
    toSlots: () -> Unit = {},
    toMain: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Лобби",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                GameCard(
                    title = "CoinFlip",
                    description = "Подбрось монетку",
                    onClick = toCoinFlip
                )
            }
            Box(
                modifier = Modifier.weight(1f)
            ) {
                GameCard(
                    title = "Mines",
                    description = "Мины",
                    onClick = toMines
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                GameCard(
                    title = "Roulette",
                    description = "Европейская рулетка",
                    onClick = toRoulette
                )
            }
            Box(
                modifier = Modifier.weight(1f)
            ) {
                GameCard(
                    title = "Slots",
                    description = "Слоты",
                    onClick = toSlots
                )
            }
        }
        Button(
            onClick = toMain
        ) {
            Text(
                text = "Назад"
            )
        }
    }
}

@Composable
fun GameCard(
    title: String = "",
    description: String = "",
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Black)
            .padding(10.dp)
            .aspectRatio(1f)
            .clickable{onClick()}
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
private fun LobbyScreenPrev() {
    LobbyScreen()
}