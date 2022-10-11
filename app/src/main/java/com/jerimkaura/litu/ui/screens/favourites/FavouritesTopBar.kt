package com.jerimkaura.litu.ui.screens.favourites

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jerimkaura.litu.R

@Composable
fun FavouritesTopBar(){
    TopAppBar(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 0.dp)
            .clip(
                shape = RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp)
            ),
        title = { Text(text = "Favourites", textAlign = TextAlign.Center) },
        elevation = 0.dp,
        backgroundColor = if (isSystemInDarkTheme()) {
            Color(0xff202121)
        } else {
            Color(0xffFF9202)
        },
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_circle_left),
                    contentDescription = "Menu Icon"
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                BadgedBox(
                    badge = {
                        Badge(
                            backgroundColor = if (isSystemInDarkTheme()) Color(
                                0xffFF9202
                            ) else Color.White
                        ) {
                            Text(
                                text = "3",
                                color = if (isSystemInDarkTheme()) Color.White else Color(
                                    0xffFF9202
                                )
                            )
                        }
                    }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_shopping_cart),
                        contentDescription = ""
                    )
                }
            }
        }
    )
}