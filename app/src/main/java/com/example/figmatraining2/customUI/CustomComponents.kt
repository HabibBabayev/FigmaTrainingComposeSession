package com.example.figmatraining2.customUI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmatraining2.R
import com.example.figmatraining2.ui.theme.PinkScheme
import com.example.figmatraining2.ui.theme.jostRegular
import com.example.figmatraining2.ui.theme.staticInter


@Composable
fun CustomHeader(text: String){
    Text(text = text,
        fontSize = 35.sp,
        color = Color.Black,
        fontWeight = FontWeight.W900,
    )
}
@Composable
fun SubmitButtonCustom(
    text: String,
    onSubmitClick:()->   Unit
){
    FilledTonalButton(onClick = {onSubmitClick()},
        Modifier
            .size(width = 200.dp, height = 60.dp),
        shape = ButtonDefaults.filledTonalShape,
        colors = ButtonColors(PinkScheme,Color.White,PinkScheme, Color.White)
    ) {
        Text(text = "$text",
            color = Color.White,
            fontFamily = staticInter,
            fontWeight = FontWeight.W600)
    }
}
@Composable
fun GoBackIconButtonCustom(modifier: Modifier, onGoBackClick:()-> Unit){


    IconButton(onClick = {onGoBackClick()},
        modifier
    ) {
        Icon(painterResource(R.drawable.back_logo_thicker), contentDescription = null,
            Modifier.border(BorderStroke(1.dp,Color.White),
                shape = RoundedCornerShape(10.dp))
                .padding(10.dp)
                .size(15.dp)

        )
    }
}

