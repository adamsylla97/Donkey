package com.donkey.navigation

sealed class Screen(val route: String) {
    object Inbox: Screen("inbox")
}