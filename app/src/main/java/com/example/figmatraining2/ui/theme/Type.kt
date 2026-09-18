package com.example.figmatraining2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.figmatraining2.R.array.com_google_android_gms_fonts_certs
import com.example.figmatraining2.R.font


// Set of Material typography styles to start with
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = com_google_android_gms_fonts_certs
)
val poppin= GoogleFont("poppin")
//val inter=FontFamily(
//    Font(googleFont = poppin, fontProvider = provider),
//    androidx.compose.ui.text.font.Font(resId = font.static_inter)
//)
val poppin1= FontFamily(
    Font(font.poppins_italic, FontWeight.Light)
)
val poppinBold=FontFamily(
    Font(font.poppins_bold, FontWeight.Bold)
)
val jostRegular=FontFamily(
    Font(font.jost_regular, FontWeight.Normal)
)
val blackOps=FontFamily(
    Font(font.black_ops_font, FontWeight.Normal)
)
val openSans= FontFamily(
    Font(font.open_sans, FontWeight.Normal)
)
val staticInter=FontFamily(
    Font(font.static_inter, FontWeight.Normal)
)
val montserrat= FontFamily(
    Font(font.montserrat, FontWeight.Normal)
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)