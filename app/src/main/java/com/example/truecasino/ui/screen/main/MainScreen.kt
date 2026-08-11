package com.example.truecasino.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.truecasino.data.repository.CasinoRepository
import com.example.truecasino.ui.theme.BloodRed
import com.example.truecasino.ui.theme.ShadowBlack
import com.example.truecasino.ui.theme.Vanilla

@Composable
fun MainScreen(
    toLobby: () -> Unit = {},
    toLeaders: () -> Unit = {},
    toShop: () -> Unit = {},
    viewModel: MainViewModel = MainViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ShadowBlack),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .background(ShadowBlack)
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "TrueCasino",
                color = Vanilla,
                fontSize = 25.sp
            )
            Text(
                text = "${viewModel.balance} ГЕ",
                color = Vanilla,
                fontSize = 25.sp
            )
            Text(
                text = viewModel.username,
                color = Vanilla,
                fontSize = 25.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(
                    topEnd = 50.dp,
                    topStart = 50.dp
                ))
                .background(BloodRed)
                .padding(
                    top = 40.dp,
                    start = 25.dp,
                    end = 25.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            MainCard(
                title = "Лобби",
                description = "Все игры",
                onClick = toLobby
            )
            MainCard(
                title = "Лидеры",
                description = "Ну вы поняли",
                onClick = toLeaders
            )
            MainCard(
                title = "Магазин",
                description = "(И промокоды)",
                onClick = toShop
            )
        }
    }
}

@Composable
fun MainCard(title: String = "", description: String = "", onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Vanilla)
            .padding(15.dp)
            .clickable{onClick()}
            .aspectRatio(2f)
    ) {
        Text(
            text = title,
            fontSize = 25.sp,
            color = ShadowBlack
        )
        Text(
            text = description,
            fontSize = 20.sp,
            color = ShadowBlack
        )
    }
}

@Preview
@Composable
private fun MainScreenPrev() {
    MainScreen()
}