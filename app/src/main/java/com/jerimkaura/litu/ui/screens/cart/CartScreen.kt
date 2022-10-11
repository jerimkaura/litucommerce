package com.jerimkaura.litu.ui.screens.cart

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jerimkaura.litu.R
import com.jerimkaura.litu.ui.composables.IconCircleBackground
import com.jerimkaura.litu.ui.screens.cart.components.CartHeader
import com.jerimkaura.litu.ui.theme.LituTheme

@Composable
fun CartScreen(navController: NavController) {
    LituTheme {
        var payableSum by remember { mutableStateOf(0) }

        Scaffold(
            topBar = { CartTopBar(navController) },
            content = { paddingValues ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 60.dp),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                    ) {
                        TopCartSection(payableSum)
                        ShoppingCartItems(
                            onIncrease = { price, itemCount -> payableSum += (price * itemCount) },
                            onDecrease = { price, _ -> payableSum -= (price) }
                        )
                        ShoppingCartItems2(
                            onIncrease = { price, itemCount -> payableSum += (price * itemCount) },
                            onDecrease = { price, _ -> payableSum -= (price) }
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun ShoppingCartItems(
    onIncrease: (price: Int, itemCount: Int) -> Unit,
    onDecrease: (price: Int, itemCount: Int) -> Unit
) {
    val itemCount = remember { mutableStateOf(0) }
    val price by remember { mutableStateOf(1500) }
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Card(
            modifier = Modifier
                .padding(0.dp)
                .height(120.dp)
                .width(150.dp)
                .clip(RoundedCornerShape(15.dp))
                .padding(vertical = 2.dp)
        ) {
            val painter = painterResource(id = R.drawable.girl_summer_dress)
            Image(
                painter = painter, contentDescription = "", Modifier
                    .fillMaxSize(), contentScale = ContentScale.Crop
            )

        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Girl Summer Dress",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                IconCircleBackground(iconId = R.drawable.ic_delete, size = 30.dp, onClick = {})
            }
            Text(
                text = "Ksh. ${price * itemCount.value}",
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconCircleBackground(iconId = R.drawable.ic_minus, size = 30.dp, onClick = {
                        if (itemCount.value != 0) {
                            itemCount.value--
                            onDecrease.invoke(price, itemCount.value)
                        }
                        Log.e("ITEMS", "ShoppingCartItems: ${itemCount.value}, $price")
                    })
                    Text(
                        text = itemCount.value.toString(),
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    IconCircleBackground(iconId = R.drawable.ic_plus, size = 30.dp, onClick = {
                        itemCount.value++
                        onIncrease.invoke(price, itemCount.value)
                        Log.e("ITEMS", "ShoppingCartItems: ${itemCount.value}, $price")
                    })
                }

            }
        }

    }
}


@Composable
fun ShoppingCartItems2(
    onIncrease: (price: Int, itemCount: Int) -> Unit,
    onDecrease: (price: Int, itemCount: Int) -> Unit
) {
    val itemCount = remember { mutableStateOf(0) }
    val price by remember { mutableStateOf(1500) }
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Card(
            modifier = Modifier
                .padding(0.dp)
                .height(120.dp)
                .width(150.dp)
                .clip(RoundedCornerShape(15.dp))
                .padding(vertical = 2.dp)
        ) {
            val painter = painterResource(id = R.drawable.mens_shoes)
            Image(
                painter = painter, contentDescription = "", Modifier
                    .fillMaxSize(), contentScale = ContentScale.Crop
            )

        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Men's Fashion Shoes",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                IconCircleBackground(iconId = R.drawable.ic_delete, size = 30.dp, onClick = {})
            }
            Text(
                text = "Ksh. ${price * itemCount.value}",
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconCircleBackground(iconId = R.drawable.ic_minus, size = 30.dp, onClick = {
                        if (itemCount.value > 0) {
                            itemCount.value--
                            onDecrease.invoke(price, itemCount.value)
                        }
                    })
                    Text(
                        text = itemCount.value.toString(),
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    IconCircleBackground(iconId = R.drawable.ic_plus, size = 30.dp, onClick = {
                        itemCount.value++
                        onIncrease.invoke(price, itemCount.value)
                    })
                }

            }
        }

    }
}

@Composable
fun TopCartSection(totalPrice: Int) {
    Column {
        CartHeader("Your Basket", "Check out your picks")
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
                    text = "KES. $totalPrice",
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
