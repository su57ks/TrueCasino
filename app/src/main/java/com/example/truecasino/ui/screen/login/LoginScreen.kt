package com.example.truecasino.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewPropertyAnimatorListenerAdapter
import com.example.truecasino.ui.components.Modal
import com.example.truecasino.ui.theme.BloodRed
import com.example.truecasino.ui.theme.ShadowBlack
import com.example.truecasino.ui.theme.Vanilla
import java.nio.file.WatchEvent

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = LoginViewModel(),
    onSuccess: () -> Unit = {},
    toRegistration: () -> Unit ={}
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState is LoginUiState.Success) {
        onSuccess()
        //TODO("Нормальный переход")
    }
    val scrollState = rememberScrollState()
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var modalTitle by remember { mutableStateOf("") }
    var modalDescription by remember { mutableStateOf("") }
    var isShowing by remember { mutableStateOf(false) }

    fun login(){
        if (login.length < 5) {
            modalTitle = "Слишком короткое имя"
            modalDescription = "Пожалуйста, используйте для логина минимум 5 символов"
            isShowing = true
            return
        }
        if (password.length < 8) {
            modalTitle = "Слишком короткий пароль"
            modalDescription = "Пожалуйста, используйте не менее 8 символов в пароле"
            isShowing = true
            return
        }
        if (login.length > 25) {
            modalTitle = "Слишком длинное имя"
            modalDescription = "Пожалуйста, используйте для логина максимум 25 символов"
            isShowing = true
            return
        }
        viewModel.login(
            username = login,
            password = password
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ShadowBlack)
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier.padding(
                start = 20.dp,
                bottom = 40.dp,
                top = 30.dp
            )
        ) {
            Text(
                text = "TrueCasino",
                color = Vanilla,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Вход",
                color = Vanilla,
                fontSize = 50.sp,
                fontWeight = FontWeight.Black
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(
                    topStart = 50.dp,
                    topEnd = 50.dp
                ))
                .background(BloodRed)
                .padding(
                    top = 75.dp,
                    bottom = 100.dp
                )
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            TextField(
                value = login,
                onValueChange = { login = it },
                placeholder = { Text(
                    text = "Логин",
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
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(
                    text = "Пароль",
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
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    login()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Vanilla,
                    contentColor = ShadowBlack
                )
            ) {
                Text(
                    text = "Войти",
                    fontSize = 25.sp,
                    color = ShadowBlack
                )
            }
            Spacer(modifier = Modifier.weight(5f))
            Text(
                text = "Нет аккаунта?\nРегистрация",
                modifier = Modifier.clickable { toRegistration() },
                color = Vanilla,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
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
private fun LoginScreenPrev() {
    LoginScreen()
}
