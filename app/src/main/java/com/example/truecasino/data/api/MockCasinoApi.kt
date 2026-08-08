package com.example.truecasino.data.api

class MockCasinoApi : CasinoApi {
    private var user: String = ""
    private var balance: Long = 100_000

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
        TODO("Not yet implemented")
    }

}