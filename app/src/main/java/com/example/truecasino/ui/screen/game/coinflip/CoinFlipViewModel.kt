package com.example.truecasino.ui.screen.game.coinflip

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truecasino.data.repository.CasinoRepository
import kotlinx.coroutines.launch

class CoinFlipViewModel (
    private val repository: CasinoRepository = CasinoRepository
) : ViewModel() {
    var username by mutableStateOf("")
    var balance by mutableStateOf(0L)

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
            val response = repository.getBalance()
        }
    }
}