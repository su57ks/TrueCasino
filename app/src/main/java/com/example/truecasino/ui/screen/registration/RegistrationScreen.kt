package com.example.truecasino.ui.screen.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.truecasino.ui.screen.login.LoginUiState

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = RegistrationViewModel(),
    onSuccess: () -> Unit = {},
    toLogin: () -> Unit ={}
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is RegistrationUiState.Success) {
            onSuccess()
        }
    }

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "Регистрация"
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
            onClick = {onSuccess()}
        ){
            Text(
                text = "Войти"
            )
        }
        Text(
            text = "Есть аккаунт? Вход",
            modifier = Modifier.clickable{toLogin()}
        )
    }
}

@Preview
@Composable
private fun RegistrationScreenPrev() {
    RegistrationScreen()
}
