package com.example.truecasino.data.repository

import com.example.truecasino.data.api.CasinoApi
import com.example.truecasino.data.api.MockCasinoApi

class CasinoRepository {
    private val api: CasinoApi = MockCasinoApi()

    suspend fun login(username: String, password: String) = api.login(username, password)
}