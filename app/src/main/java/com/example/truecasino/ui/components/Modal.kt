package com.example.truecasino.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.truecasino.ui.theme.BloodRed
import com.example.truecasino.ui.theme.ShadowBlack
import com.example.truecasino.ui.theme.Vanilla

@Composable
fun Modal(
    title: String = "Error",
    description: String = "Too good player",
    onClose: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000))
            .clickable{onClose()},
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .clip(RoundedCornerShape(30.dp))
                .background(ShadowBlack)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ShadowBlack)
                    .padding(
                        start = 20.dp,
                        top = 20.dp,
                        bottom = 10.dp,
                        end = 20.dp
                    )
            ){
                Text(
                    text = title,
                    color = Vanilla,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 30.sp
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(
                        topEnd = 25.dp,
                        topStart = 25.dp
                    ))
                    .background(BloodRed)
                    .padding(
                        start = 20.dp,
                        top = 10.dp,
                        bottom = 20.dp,
                        end = 20.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = description,
                    color = Vanilla,
                    fontSize = 25.sp
                )
                Button(
                    onClick = onClose,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Vanilla,
                        contentColor = ShadowBlack
                    )
                ) {
                    Text(
                        text = "Закрыть",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ModalPrev() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BloodRed)
    ) {
        Text(
            text = "Text",
            fontSize = 40.sp,
            color = ShadowBlack
        )
        Text(
            text = "Text",
            fontSize = 40.sp,
            color = Vanilla
        )
    }
    Modal()
}