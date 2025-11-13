package io.rndev.banksimulator.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Elegant color palette
private val BankBlue = Color(0xFF1E3A8A)
private val BankLightBlue = Color(0xFF3B82F6)
private val BankAccent = Color(0xFF06D6A0)
private val BankGreen = Color(0xFF10B981)
private val BankRed = Color(0xFFEF4444)
private val BankGray = Color(0xFF6B7280)
private val BankLightGray = Color(0xFFF9FAFB)
private val BankDarkGray = Color(0xFF374151)

private val LightColorScheme = lightColorScheme(
    primary = BankBlue,
    onPrimary = Color.White,
    primaryContainer = BankLightBlue,
    onPrimaryContainer = Color.White,
    secondary = BankAccent,
    onSecondary = Color.White,
    tertiary = BankGreen,
    error = BankRed,
    background = BankLightGray,
    onBackground = BankDarkGray,
    surface = Color.White,
    onSurface = BankDarkGray,
    surfaceVariant = Color(0xFFF1F5F9),
    onSurfaceVariant = BankGray
)

private val DarkColorScheme = darkColorScheme(
    primary = BankLightBlue,
    onPrimary = Color.White,
    primaryContainer = BankBlue,
    onPrimaryContainer = Color.White,
    secondary = BankAccent,
    onSecondary = Color.Black,
    tertiary = BankGreen,
    error = BankRed,
    background = Color(0xFF0F172A),
    onBackground = Color.White,
    surface = Color(0xFF1E293B),
    onSurface = Color.White,
    surfaceVariant = Color(0xFF334155),
    onSurfaceVariant = Color(0xFFCBD5E1)
)

private val BankTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
)

private val BankShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp)
)

@Composable
fun BankTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = BankTypography,
        shapes = BankShapes,
        content = content
    )
}