package com.example.truecasino.ui.screen.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truecasino.data.repository.CasinoRepository
import kotlinx.coroutines.launch

class MainViewModel (
    private val repository: CasinoRepository = CasinoRepository
) : ViewModel() {
    var username by mutableStateOf("")

    init {
        getUsername()
    }

    fun getUsername(){
        viewModelScope.launch {
            val response = repository.getUsername()
            username = response
        }
    }
}