package com.jerimkaura.litu.ui

sealed class Route(val route:String){
    object HomeScreen: Route("home_screen")
    object CartScreen: Route("cart_screen")
    object FavouritesScreen: Route("favourite_screen")
    object SettingsScreen: Route("settings_screen")
    object ProductScreen: Route("product_screen")
    object RegisterScreen: Route("auth_screen")
    object ForumScreen: Route("forum_screen")
    object SalesScreen: Route("sales_screen")
    object RequestItemScreen: Route("request_item_screen")
}