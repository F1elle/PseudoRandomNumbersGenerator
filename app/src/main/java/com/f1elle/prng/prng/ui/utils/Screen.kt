package com.f1elle.prng.prng.ui.utils

sealed class Screen(val route: String) {
    object PRNGScreen: Screen("PRNGScreen")
    object CoprScreen: Screen("CoprScreen")
}