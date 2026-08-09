package com.example.truecasino.data.api

import android.util.Log

class MockCasinoApi : CasinoApi {
    private var user: String = ""
    private var balance: Long = 100_000

    override suspend fun login(
        username: String,
        password: String
    ): AuthResponse {
        user = username
        Log.d("USERNAME", user)
        return AuthResponse(
            token = "mock_$user",
            username = user,
            balance = balance
        )
    }

    override suspend fun registration(
        username: String,
        password: String
    ): AuthResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getUsername(): String {
        return user
    }
}