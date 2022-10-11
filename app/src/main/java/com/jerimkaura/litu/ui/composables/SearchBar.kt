package com.jerimkaura.litu.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun SearchBar() {
    val (value, onValueChange) = remember { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontSize = 20.sp),
        leadingIcon = { Icon(Icons.Filled.Search, null, tint = Color(0xffFF9202)) },
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .background(
                color = if (isSystemInDarkTheme()) Color(0xff202121) else Color(0xffEFEEEF),
                RoundedCornerShape(16.dp)
            ),
        placeholder = { Text(text = "What are you looking for today?", color = Color(0xFF465E5E)) },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = Color.DarkGray
        )
    )
}