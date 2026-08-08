package com.example.truecasino.ui.screen

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "Вход"
        )
        OutlinedTextField(
            value = login,
            onValueChange = {login = it},
            label = {Text(text = "Логин")}
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text(text = "Пароль")}
        )
        Button(
            onClick = {}
        ){
            Text(
                text = "Войти"
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPrev() {
    LoginScreen()
}
