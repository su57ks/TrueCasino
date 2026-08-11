package com.example.truecasino.ui.screen.game.coinflip

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truecasino.data.repository.CasinoRepository
import com.example.truecasino.ui.screen.login.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoinFlipViewModel (
    private val repository: CasinoRepository = CasinoRepository
) : ViewModel() {
    var username by mutableStateOf("")
    var balance by mutableStateOf(0L)
    private val _uiState = MutableStateFlow<CoinFlipUiState>(CoinFlipUiState.Idle)
    val uiState: StateFlow<CoinFlipUiState> = _uiState

    init {
        getUsername()
        getBalance()
    }

    fun getUsername(){
        viewModelScope.launch {
            val response = repository.getUsername()
            username = response
        }
    }

    fun getBalance(){
        viewModelScope.launch {
            val response = repository.getBalance()
            balance = response
        }
    }

    fun bet(
        betSize: Long,
        type: Int  //0 - орел, 1 - решка
    ){
        viewModelScope.launch {
            val response = repository.betCoinFlip(
                betSize = betSize,
                type = type
            )
            balance = repository.getBalance()
            _uiState.value = CoinFlipUiState.Success(response)
        }
    }
}

sealed class CoinFlipUiState {
    object Idle : CoinFlipUiState()
    object Loading : CoinFlipUiState()
    data class Success(val result: Boolean) : CoinFlipUiState()
    data class Error(val message: String) : CoinFlipUiState()
}