package com.example.truecasino.data.api

data class AuthResponse(
    val token: String,
    val username: String,
    val balance: Long
)