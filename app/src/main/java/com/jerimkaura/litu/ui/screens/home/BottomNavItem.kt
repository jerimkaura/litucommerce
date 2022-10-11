package com.jerimkaura.litu.ui.screens.home

import com.jerimkaura.litu.R
import com.jerimkaura.litu.ui.Route

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var route: String,
    var badgeCount: Int = 0
) {

    object Home : BottomNavItem(
        "Home",
        R.drawable.ic_home,
        Route.HomeScreen.route
    )

    object Favourite : BottomNavItem(
        "Favourite",
        R.drawable.ic_favourite,
        Route.FavouritesScreen.route
    )

    object Settings : BottomNavItem(
        "Settings",
        R.drawable.ic_settings,
        Route.SettingsScreen.route
    )

    object Cart : BottomNavItem(
        "Cart",
        R.drawable.ic_shopping_cart,
        Route.CartScreen.route,
        badgeCount = 3
    )
}
