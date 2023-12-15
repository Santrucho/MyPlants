package com.santrucho.myplants.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = CoffeeBrown,
    primaryVariant = StrongBrown,
    secondary = Teal200,
    background = LightBrown,
    onPrimary = Black
)

private val LightColorPalette = lightColors(
    primary = CoffeeBrown,
    primaryVariant = StrongBrown,
    secondary = Teal200,
    background = LightBrown,
    onPrimary = Black

    /* Other default colors to override

    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MyPlantsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}