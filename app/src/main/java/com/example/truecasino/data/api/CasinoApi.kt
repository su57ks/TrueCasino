package com.example.truecasino.data.api

interface CasinoApi {
    suspend fun login(username: String, password: String): AuthResponse
    suspend fun registration(username: String, password: String): AuthResponse
    suspend fun getUsername(): String
    suspend fun getBalance(): Long
    suspend fun betCoinFlip(betSize: Long, type: Int): Boolean //true - победа, false - проигрыш
}