package com.jerimkaura.litu.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.jerimkaura.litu.data.local.Category

@Composable
fun CategoryCard(category: Category) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .padding(5.dp)
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
        ) {
            val painter = painterResource(id = category.imageUrl)
            Image(
                painter = painter, contentDescription = "", Modifier
                    .fillMaxSize()
                    .size(90.dp)
                    .clip(CircleShape), contentScale = ContentScale.Crop
            )

        }
        Text(
            text = category.name,
            modifier = Modifier.padding(vertical = 5.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )
    }
}