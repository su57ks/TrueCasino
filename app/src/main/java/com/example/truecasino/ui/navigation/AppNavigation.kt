package com.example.truecasino.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.truecasino.ui.screen.lobby.LobbyScreen
import com.example.truecasino.ui.screen.login.LoginScreen
import com.example.truecasino.ui.screen.main.MainScreen
import com.example.truecasino.ui.screen.onboarding.AgreeScreen
import com.example.truecasino.ui.screen.registration.RegistrationScreen

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
            LobbyScreen()
        }
    }
}