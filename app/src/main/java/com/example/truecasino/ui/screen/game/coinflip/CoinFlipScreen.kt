package com.example.truecasino.ui.screen.game.coinflip

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ModalNavigationDrawer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewPropertyAnimatorListenerAdapter
import com.example.truecasino.ui.theme.BloodRed
import com.example.truecasino.ui.theme.ShadowBlack
import com.example.truecasino.ui.theme.Vanilla
import com.example.truecasino.R
import com.example.truecasino.ui.components.Modal

@Composable
fun CoinFlipScreen(
    toLobby: () -> Unit = {},
    viewModel: CoinFlipViewModel = CoinFlipViewModel()
    ) {
    var betSize by remember { mutableStateOf("1") }
    val uiState by viewModel.uiState.collectAsState()

    var lastResult by remember { mutableStateOf(2) }
    var lastBet by remember { mutableStateOf(2) }

    val scrollState = rememberScrollState()

    var modalTitle by remember { mutableStateOf("") }
    var modalDescription by remember { mutableStateOf("") }
    var isShowing by remember { mutableStateOf(false) }

    when (val state = uiState) {
        is CoinFlipUiState.Success -> {
            lastResult = if (state.result) 1 else 0
        }
        else -> {}
    }
    fun placeBet(type: Int) {
        try {
            val bet = betSize.toLong()

            if (bet < 1) {
                modalTitle = "Невозможная ставка"
                modalDescription = "Вы не можете поставить меньше 1"
                isShowing = true
                return
            }

            if (bet > viewModel.balance) {
                modalTitle = "Невозможная ставка"
                modalDescription = "Недостаточно средств! Баланс: ${viewModel.balance} ГЕ"
                isShowing = true
                return
            }

            viewModel.bet(betSize = bet, type = type)
            lastBet = type

        } catch (e: NumberFormatException) {
            modalTitle = "Невозможная ставка"
            modalDescription = "Вы не можете поставить '$betSize'"
            isShowing = true
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ShadowBlack)
            .verticalScroll(scrollState),
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
                .weight(1f)
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
                text = if (lastResult == 0) "Проигрыш"
                else if (lastResult == 1) "Победа"
                else "Игры не было",
                color = Vanilla,
                fontSize = 20.sp
            )
            if (lastResult != 2){
                if ((lastResult == 1 && lastBet == 1) || (lastResult == 0 && lastBet == 0)){
                    Image(
                        painter = painterResource(R.drawable.earth),
                        contentDescription = ""
                    )
                    Text(
                        text = "Выпало: решка",
                        fontSize = 20.sp,
                        color = Vanilla
                    )
                }
                else{
                    Image(
                        painter = painterResource(R.drawable.sun),
                        contentDescription = ""
                    )
                    Text(
                        text = "Выпало: орел",
                        fontSize = 20.sp,
                        color = Vanilla
                    )
                }
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
                    onClick = {placeBet(0) },
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
                    onClick = {placeBet(1) },
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
    if (isShowing){
        Modal(
            title = modalTitle,
            description = modalDescription,
            onClose = {isShowing = false}
        )
    }
}

@Preview
@Composable
private fun CoinFlipScreenPrev() {
    CoinFlipScreen()
}