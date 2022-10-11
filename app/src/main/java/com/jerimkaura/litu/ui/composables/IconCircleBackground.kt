package com.jerimkaura.litu.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconCircleBackground(iconId: Int, size: Dp, onClick: () -> Unit) {
    Icon(
        painter = painterResource(id = iconId),
        contentDescription = "",
        modifier = Modifier
            .padding(5.dp)
            .clip(CircleShape)
            .size(size)
            .border(
                width = 1.dp,
                color = if (isSystemInDarkTheme()) Color(0xff202121) else Color(0xffEFEEEF),
                shape = CircleShape
            )
            .clickable { onClick.invoke() }
            .padding(5.dp),
        tint = Color(0xffFF9202)
    )
}