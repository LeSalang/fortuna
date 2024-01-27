package com.lesa.fortuna.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lesa.fortuna.R

val fortunaFontFamily = FontFamily(
    Font(R.font.caesardressingcyrillic, FontWeight.Normal),
    Font(R.font.caesardressingcyrillic, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fortunaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 50.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fortunaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 1000.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fortunaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)

