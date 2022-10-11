package com.jerimkaura.litu.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.jerimkaura.litu.R
import com.jerimkaura.litu.data.local.Product
import com.jerimkaura.litu.ui.Route
import com.jerimkaura.litu.ui.composables.IconCircleBackground

@Composable
fun ProductCard(product: Product, navController: NavController) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .clickable {
                navController.navigate(Route.ProductScreen.route)
            }
            .padding(5.dp)
            .wrapContentHeight()
    ) {
        Card(
            modifier = Modifier
                .height(150.dp)
                .clip(RoundedCornerShape(15.dp))
        ) {
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = product.image)
                    .apply(block = fun ImageRequest.Builder.() {
                        placeholder(R.drawable.placeholder)
                        scale(Scale.FILL)
                    }).build()
            )
            Image(
                painter = painter, contentDescription = "", Modifier
                    .fillMaxSize(), contentScale = ContentScale.Crop
            )
            Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.padding(5.dp)) {
                Text(
                    text = "MOQ: ${product.soldAmount}",
                    Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(0.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xffFF9202).copy(alpha = 0.90F))
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

            }

        }

        Text(text = product.name, modifier = Modifier.padding(vertical = 5.dp))
        Row(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = product.price,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Row(modifier = Modifier) {
                IconCircleBackground(
                    iconId = R.drawable.ic_favourite,
                    size = 30.dp,
                    onClick = {
                    }
                )
                IconCircleBackground(
                    iconId = R.drawable.ic_plus,
                    size = 30.dp,
                    onClick = {
                    }
                )
            }

        }

    }
}