package com.example.truecasino.ui.screen.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truecasino.data.repository.CasinoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegistrationViewModel (
    private val repository: CasinoRepository = CasinoRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<RegistrationUiState>(RegistrationUiState.Idle)
    val uiState: StateFlow<RegistrationUiState> = _uiState

    fun registration(
        username: String,
        password: String
    ){
        if (username.isBlank()) {
            _uiState.value = RegistrationUiState.Error("Имя не может быть пустым")
            return
        }
        if (password.isBlank()) {
            _uiState.value = RegistrationUiState.Error("Пароль не может быть пустым!")
            return
        }

        _uiState.value = RegistrationUiState.Loading

        viewModelScope.launch {
            try {
                val response = repository.registration(username, password)
                _uiState.value = RegistrationUiState.Success(response.token)
            }
            catch (e: Exception){
                _uiState.value = RegistrationUiState.Error(e.message ?: "Ошибка")
            }
        }
    }
}

sealed class RegistrationUiState {
    object Idle : RegistrationUiState()
    object Loading : RegistrationUiState()
    data class Success(val token: String) : RegistrationUiState()
    data class Error(val message: String) : RegistrationUiState()
}