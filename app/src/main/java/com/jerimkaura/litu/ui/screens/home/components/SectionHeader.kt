package com.jerimkaura.litu.ui.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jerimkaura.litu.R
import com.jerimkaura.litu.ui.composables.IconCircleBackground

@Composable
fun SectionHeader(heading: String, description: String) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                color = Color(0xffFF9202),
                thickness = 2.dp,
                modifier = Modifier
                    .width(20.dp).padding(horizontal = 10.dp)
                    .weight(1.0f), startIndent = 0.dp
            )
            Text(
                text = heading,
                modifier = Modifier
                    .weight(8.0f),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )
            IconCircleBackground(
                iconId = R.drawable.ic_arrow_circle_right,
                size = 30.dp,
                onClick = {
                }
            )
        }
        Text(
            text = description,
            fontWeight = FontWeight.Light,
        )
    }

}