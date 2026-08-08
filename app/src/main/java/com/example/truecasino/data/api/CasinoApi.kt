package com.example.truecasino.data.api

interface CasinoApi {
    suspend fun login(username: String, password: String): AuthResponse
    suspend fun registration(username: String, password: String): AuthResponse
}