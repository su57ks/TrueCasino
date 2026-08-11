package com.example.truecasino.ui.screen.game.coinflip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewPropertyAnimatorListenerAdapter
import com.example.truecasino.ui.theme.BloodRed
import com.example.truecasino.ui.theme.ShadowBlack
import com.example.truecasino.ui.theme.Vanilla

@Composable
fun CoinFlipScreen(
    toLobby: () -> Unit = {},
    viewModel: CoinFlipViewModel = CoinFlipViewModel()
    ) {
    var betSize by remember { mutableStateOf("1") }
    val uiState by viewModel.uiState.collectAsState()
    var last by remember { mutableStateOf(2) }
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
            Text(
                text = "CoinFlip",
                color = Vanilla,
                fontSize = 30.sp
            )
            Text(
                text = if (last == 0) "Проигрыш"
                else if (last == 1) "Победа"
                else "Игры не было",
                color = Vanilla,
                fontSize = 20.sp
            )
            when (val state = uiState) {
                is CoinFlipUiState.Success -> {
                    last = if (state.result) 1 else 0
                }
                else -> {}
            }
            TextField(
                value = betSize,
                onValueChange = { betSize = it },
                placeholder = { Text(
                    text = "Ставка",
                    color = ShadowBlack
                ) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Vanilla,
                    unfocusedContainerColor = Vanilla
                ),
                shape = RoundedCornerShape(30.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Vanilla)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = {
                        viewModel.bet(
                            betSize = betSize.toLong(),
                            type = 0
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .border(
                            width = 2.dp,
                            color = BloodRed,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Vanilla,
                        contentColor = ShadowBlack
                    )
                ) {
                    Text(
                        text = "Орел"
                    )
                }
                Button(
                    onClick = {
                        viewModel.bet(
                            betSize = betSize.toLong(),
                            type = 1
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .border(
                            width = 2.dp,
                            color = BloodRed,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Vanilla,
                        contentColor = ShadowBlack
                    )
                ) {
                    Text(
                        text = "Решка"
                    )
                }
            }
            Button(
                onClick = {toLobby()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Vanilla,
                    contentColor = ShadowBlack
                )
            ) {
                Text(text = "В лобби")
            }
        }
    }
}

@Preview
@Composable
private fun CoinFlipScreenPrev() {
    CoinFlipScreen()
}