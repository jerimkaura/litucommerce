package com.jerimkaura.litu.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardImageBackground(header: String, description: String, buttonText: String, imageId: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            val painter = painterResource(id = imageId)
            Image(
                painter = painter, contentDescription = "", Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .fillMaxSize(), contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color(0xff000000).copy(alpha = 0.70F))
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = header,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

                Text(
                    text = description,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )

                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = buttonText, color = Color.White)
                }
            }
        }
    }
}