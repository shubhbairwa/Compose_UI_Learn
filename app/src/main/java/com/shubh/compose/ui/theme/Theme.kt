package com.shubh.compose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),       // Accent color (main brand color)
    onPrimary = Color.Black,           // Text/icon color on primary
    secondary = Color(0xFF03DAC6),     // Secondary color (complementary)
    onSecondary = Color(0xFF343434),   // Text/icon color on secondary
    background = Color.Black,          // Background color
    onBackground = Color.Blue,         // Text/icon color on background
    surface = Color(0xFF121212),       // Surface color (cards, dialogs)
    onSurface = Color.White            // Text/icon color on surface

)


private val LightColorScheme = lightColorScheme(

    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color(0xFFFFFFFF),
    background = Color.White,
    onBackground = Color.Black,
    surface = Color(0xFFF1F1F1),
    onSurface = Color.Black
)

@Composable
fun ComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) DarkColorScheme else LightColorScheme
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}