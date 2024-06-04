package com.kjkc.memoirclient.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFAFAFA),
    secondary = Color(0xF5F5F5),
    tertiary = Color(0xF0F0F0)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFAFAFA),
    secondary = Color(0xF5F5F5),
    tertiary = Color(0xF0F0F0)
)

@Composable
fun MemoirClientTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shape,
        content = content
    )
}