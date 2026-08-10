package com.example.truecasino.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.truecasino.ui.screen.game.coinflip.CoinFlipScreen
import com.example.truecasino.ui.screen.game.mines.MinesScreen
import com.example.truecasino.ui.screen.game.roulette.RouletteScreen
import com.example.truecasino.ui.screen.game.slots.SlotsScreen
import com.example.truecasino.ui.screen.lobby.LobbyScreen
import com.example.truecasino.ui.screen.login.LoginScreen
import com.example.truecasino.ui.screen.registration.RegistrationScreen
import com.example.truecasino.ui.screen.main.MainScreen
import com.example.truecasino.ui.screen.onboarding.AgreeScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "agree") {
        composable("agree"){
            AgreeScreen(
                play = {nav.navigate("login")}
            )
        }
        composable("login"){
            LoginScreen(
                onSuccess = {nav.navigate("main")},
                toRegistration = {nav.navigate("registration")}
            )
        }
        composable("main"){
            MainScreen(
                toLobby = {nav.navigate("lobby")},
                toLeaders = {nav.navigate("leaders")},
                toShop = {nav.navigate("shop")}
            )
        }
        composable("registration"){
            RegistrationScreen(
                onSuccess = {nav.navigate("main")},
                toLogin = {nav.navigate("login")}
            )
        }
        composable("lobby"){
            LobbyScreen(
                toCoinFlip = {nav.navigate("coinflip")},
                toMines = {nav.navigate("mines")},
                toRoulette = {nav.navigate("roulette")},
                toSlots = {nav.navigate("slots")},
                toMain = {nav.navigate("main")}
            )
        }
        composable("coinflip"){
            CoinFlipScreen(
                toLobby = {nav.navigate("lobby")}
            )
        }
        composable("mines"){
            MinesScreen(
                toLobby = {nav.navigate("lobby")}
            )
        }
        composable("roulette"){
            RouletteScreen(
                toLobby = {nav.navigate("lobby")}
            )
        }
        composable("slots"){
            SlotsScreen(
                toLobby = {nav.navigate("lobby")}
            )
        }
    }
}