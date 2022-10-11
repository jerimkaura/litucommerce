package com.jerimkaura.litu.ui.theme

import android.annotation.SuppressLint
import  androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = Orange800,
    primaryVariant = Orange900,
    onPrimary = Orange800,
    secondary = Orange800,
    secondaryVariant = Orange800,
    onSecondary = Color.White,
    error = Orange800,
    background = DarkBackground,
    onSurface = Color.White
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = Orange800,
    primaryVariant = Orange900,
    onPrimary = Orange800,
    secondary = Orange800,
    secondaryVariant = Orange800,
    onSecondary = Color.Black,
    error = Orange800,
    background = WhiteBackground,

)

@Composable
fun LituTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = LitudianTypography,
        shapes = Shapes,
        content = content
    )
}