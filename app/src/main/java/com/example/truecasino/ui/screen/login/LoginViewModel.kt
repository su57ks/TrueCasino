package com.example.truecasino.ui.screen.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truecasino.data.repository.CasinoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel (
    private val repository: CasinoRepository = CasinoRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState

    fun login(
        username: String,
        password: String
    ){
        if (username.isBlank()) {
            _uiState.value = LoginUiState.Error("Имя не может быть пустым")
            return
        }
        if (password.isBlank()) {
            _uiState.value = LoginUiState.Error("Пароль не может быть пустым!")
            return
        }

        _uiState.value = LoginUiState.Loading

        viewModelScope.launch {
            try {
                val response = repository.login(username, password)
                _uiState.value = LoginUiState.Success(response.token)
                Log.d("USERNAME", "success")
            }
            catch (e: Exception){
                _uiState.value = LoginUiState.Error(e.message ?: "Ошибка")
            }
        }
    }
}

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val token: String) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}