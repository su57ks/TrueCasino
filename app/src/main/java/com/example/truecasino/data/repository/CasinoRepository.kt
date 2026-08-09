package com.example.truecasino.data.repository

import com.example.truecasino.data.api.CasinoApi
import com.example.truecasino.data.api.MockCasinoApi

object CasinoRepository {
    private val api: CasinoApi = MockCasinoApi()

    suspend fun login(username: String, password: String) = api.login(username, password)
    suspend fun registration(username: String, password: String) = api.registration(username, password)
    suspend fun getUsername() = api.getUsername()
}