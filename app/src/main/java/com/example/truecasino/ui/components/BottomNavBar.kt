package com.example.truecasino.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class BottomTab(val label: String){
    MINES("Мины"),
    LEADERS("Лидеры"),
    SHOP("Магазин")
}

@Composable
fun BottomNavBar(
    currentTab: BottomTab,
    onTabClick: (BottomTab) -> Unit
) {
    TODO()
}