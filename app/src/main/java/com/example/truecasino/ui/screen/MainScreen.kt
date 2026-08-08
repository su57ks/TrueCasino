package com.example.truecasino.ui.screen

import android.content.ClipDescription
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.truecasino.R

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "TrueCasino",
                color = Color.White,
                fontSize = 25.sp
            )
            Text(
                text = "Настройки",
                color = Color.White,
                fontSize = 25.sp
            )
        }
        MainCard(
            title = "Лобби",
            description = "Все игры"
        )
        MainCard(
            title = "Лидеры",
            description = "Ну вы поняли"
        )
    }
}

@Composable
fun MainCard(title: String = "", description: String = "") {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Black)
            .padding(10.dp)
    ) {
        Text(
            text = title,
            fontSize = 25.sp,
            color = Color.White
        )
        Text(
            text = description,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun MainScreenPrev() {
    MainScreen()
}