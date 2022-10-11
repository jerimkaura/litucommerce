package com.jerimkaura.litu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jerimkaura.litu.ui.Route
import com.jerimkaura.litu.ui.screens.cart.CartScreen
import com.jerimkaura.litu.ui.screens.SettingsScreen
import com.jerimkaura.litu.ui.screens.favourites.FavouritesScreen
import com.jerimkaura.litu.ui.screens.forum.ForumScreen
import com.jerimkaura.litu.ui.screens.home.BottomNavigationBar
import com.jerimkaura.litu.ui.screens.home.HomeScreen
import com.jerimkaura.litu.ui.screens.home.RegisterScreen
import com.jerimkaura.litu.ui.screens.product.ProductScreen
import com.jerimkaura.litu.ui.screens.request_item.RequestItemScreen
import com.jerimkaura.litu.ui.screens.sales.SalesScreen
import com.jerimkaura.litu.ui.theme.LituTheme
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LituTheme {
                MainScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        var showBottomBar by rememberSaveable { mutableStateOf(false) }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        showBottomBar = when (navBackStackEntry?.destination?.route) {
            Route.HomeScreen.route -> true
            Route.SettingsScreen.route -> true
            Route.CartScreen.route -> true
            Route.FavouritesScreen.route -> true
            else -> false
        }
        Scaffold(bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(navController = navController)
            }
        }) {
            NavHost(navController = navController, startDestination = "home_screen") {
                screens(navController)
            }
        }
    }
}


private fun NavGraphBuilder.screens(navController: NavController) {
    composable(route = Route.HomeScreen.route) {
        HomeScreen(navController)
    }
    composable(route = Route.FavouritesScreen.route) {
        FavouritesScreen()
    }
    composable(route = Route.SettingsScreen.route) {
        SettingsScreen()
    }
    composable(route = Route.CartScreen.route) {
        CartScreen(navController)
    }
    composable(route = Route.ProductScreen.route) {
        ProductScreen(navController)
    }
    composable(route = Route.RegisterScreen.route) {
        RegisterScreen(navController)
    }
    composable(route = Route.ForumScreen.route) {
        ForumScreen()
    }
    composable(route= Route.SalesScreen.route){
        SalesScreen()
    }
    composable(route= Route.RequestItemScreen.route){
        RequestItemScreen()
    }
}
