package com.jerimkaura.litu.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jerimkaura.litu.R
import com.jerimkaura.litu.ui.Route
import com.jerimkaura.litu.ui.composables.IconCircleBackground
import com.jerimkaura.litu.ui.screens.home.components.navdrawer.NavDrawerItem

@Composable
fun DrawerBody(
    modifier: Modifier = Modifier,
    onItemClick: (NavDrawerItem) -> Unit
) {
    val items = listOf(
        NavDrawerItem(
            "My Items",
            Route.CartScreen.route,
            R.drawable.ic_shopping_cart
        ),
        NavDrawerItem(
            "Sales",
            Route.SalesScreen.route,
            R.drawable.ic_stores
        ),
        NavDrawerItem(
            "Forum",
            Route.ForumScreen.route,
            R.drawable.ic_forum
        ),
        NavDrawerItem(
            "Request Item",
            Route.RequestItemScreen.route,
            R.drawable.ic_request_item
        ),
        NavDrawerItem(
            "Settings",
            Route.SettingsScreen.route,
            R.drawable.ic_settings
        )
    )
    LazyColumn(modifier) {
        items(items) { navDrawerItem ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(navDrawerItem) }
                .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                IconCircleBackground(
                    iconId = navDrawerItem.icon,
                    size = 30.dp,
                    onClick = {
                    }
                )
//                Icon(imageVector = navDrawerItem.icon, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = navDrawerItem.title,
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 5.dp)
                )
            }

        }
    }
}

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Header")
    }
}
