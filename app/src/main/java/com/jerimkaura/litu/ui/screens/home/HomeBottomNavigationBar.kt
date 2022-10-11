package com.jerimkaura.litu.ui.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favourite,
        BottomNavItem.Settings,
        BottomNavItem.Cart
    )

    BottomNavigation(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
        elevation = 0.dp,
        backgroundColor = if (isSystemInDarkTheme()) {
            Color(0xff202121)
        } else {
            Color(0xffEFEEEF)
        },
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        items.forEach { item ->
            var selected = currentRoute == item.route
            BottomNavigationItem(
                selected = selected,
                selectedContentColor = Color(0xfff2900d),
                unselectedContentColor = Color.Gray,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = {
                                    Badge {
                                        Text(
                                            text = item.badgeCount.toString(),
                                            color = Color.White
                                        )
                                    }
                                }) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = item.icon),
                                    contentDescription = item.title
                                )
                            }
                        } else {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = item.icon),
                                contentDescription = item.title
                            )
                        }
                        if (selected) {
                            Text(
                                text = item.title,
                                textAlign = TextAlign.Center,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            )
        }

    }
}