package com.example.truecasino.data.api

import android.util.Log
import kotlin.random.Random

class MockCasinoApi : CasinoApi {
    private var user: String = ""
    private var balance: Long = 100_000L

    override suspend fun login(
        username: String,
        password: String
    ): AuthResponse {
        user = username
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
        user = username
        return AuthResponse(
            token = "mock_$user",
            username = user,
            balance = balance
        )
    }

    override suspend fun getUsername(): String {
        return user
    }

    override suspend fun getBalance(): Long {
        return balance
    }

    override suspend fun betCoinFlip(betSize: Long, type: Int): Boolean {
        val result = Random.nextInt(2)
        if (type == result) {
            balance += betSize
            return true
        }
        else{
            balance -= betSize
            return false
        }
    }
}