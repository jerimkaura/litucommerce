package com.jerimkaura.litu.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun TextInput() {
    var firstName = remember { mutableStateOf("") }
    OutlinedTextField(
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        value = firstName.value,
        onValueChange = { firstName.value = it },
        label = { Text(text = "Enter Firstname", fontWeight = FontWeight.Light) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp)

    )
}