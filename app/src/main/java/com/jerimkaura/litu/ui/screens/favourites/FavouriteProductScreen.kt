package com.jerimkaura.litu.ui.screens.favourites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jerimkaura.litu.R
import com.jerimkaura.litu.ui.screens.cart.components.CartHeader
import com.jerimkaura.litu.ui.theme.LituTheme


@Composable
@Preview
fun FavouritesScreen() {
    LituTheme {
        Scaffold(
            topBar = {
                FavouritesTopBar()
            },
            content = { paddingValues ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 60.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                    ) {
                        TopFavouritePageSection()
                    }
                }
            }
        )
    }
}


@Composable
fun TopFavouritePageSection() {
    Column {
        CartHeader("Your Favourites", "Items closest to your heart")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            OutlinedButton(
                shape = RoundedCornerShape(20.dp),
                onClick = {
                    // do something here
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_circle_left),
                    contentDescription = "Localized description",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = "Shop")
            }
            Row(
                modifier = Modifier, verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "KES. 15,000",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
            }
        }
        Divider(
            color = Color(0xffFF9202).copy(alpha = 0.3f),
            thickness = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp), startIndent = 0.dp
        )
    }


}