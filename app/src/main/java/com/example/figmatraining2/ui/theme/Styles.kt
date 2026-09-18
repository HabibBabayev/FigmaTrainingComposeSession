package com.example.figmatraining2.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

//AUTH SCREENS VALUE
//textfield values
//1. TextFields
val outlinedTextFieldFont=TextStyle(color = Color.Black, fontFamily = montserrat, fontWeight = FontWeight.W600)
@Composable
fun outlinedTextFieldFocusedBorders(): TextFieldColors{
   val outlinedTextFieldFocusedBorders=OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.Black,
        focusedBorderColor = PinkScheme,
       unfocusedBorderColor = Color.LightGray,
       focusedPlaceholderColor = Color.Transparent,
       cursorColor = PinkScheme,
       unfocusedPlaceholderColor = Color.LightGray,

    )
    return outlinedTextFieldFocusedBorders
}
val outlinedTextFieldCurves=ShapeDefaults.Medium

//circular decorations on the auth screens
