package com.example.artspace.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFFB5413F),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFE2DE),
    onPrimaryContainer = Color(0xFF5C0001),
    secondary = Color(0xFF725D5B),
    secondaryContainer = Color(0xFFF9E4E0),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFFE2DE),
    onPrimary = Color(0xFF5C0001),
    primaryContainer = Color(0xFFB5413F),
    onPrimaryContainer = Color.White,
    secondary = Color(0xFFF9E4E0),
)

/** Тема приложения: собственная палитра Material 3 (динамические цвета отключены). */
@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
