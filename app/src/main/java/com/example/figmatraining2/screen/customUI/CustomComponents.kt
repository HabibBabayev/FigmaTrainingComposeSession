package com.example.figmatraining2.screen.customUI

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmatraining2.R
import com.example.figmatraining2.ui.theme.Ivory
import com.example.figmatraining2.ui.theme.LightPink
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
fun CustomText(
    @StringRes text: Int
){
Text(text =text.toString(),
    color = Color.Gray,
    fontSize = 12.sp
    )
}
@Composable
fun CustomLinkForExemptions(){
    Row(Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "I don't receive a code")
        TextButton(onClick = {}) {
            Text("Please resend",
                color = PinkScheme, fontWeight = FontWeight.Bold
            )
        }
    }
}

//submit button to get authentication or login
@Composable
fun SubmitButtonCustom(
    text: String,
    onSubmitClick:()->   Unit
){
    FilledTonalButton(onClick = {onSubmitClick()},
        Modifier
            .size(width = 248.dp, height = 60.dp),
        shape = ButtonDefaults.filledTonalShape,
        colors = ButtonColors(PinkScheme,Color.White,PinkScheme, Color.White)
    ) {
        Text(text = text,
            color = Color.White,
            fontFamily = staticInter,
            fontWeight = FontWeight.W600)
    }
}
// return icon to go back to previous window
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
//Circle shaped decoration on the back of upper side of screen in authorization phase
@Composable
fun CustomBackGroundDecoration(){
    Box(Modifier.fillMaxSize()
        .background(Ivory)){
        Box(Modifier.size(210.dp)
            .align(Alignment.TopEnd)
            .offset((110).dp,(-120).dp)
            .clip(CircleShape)
            .background(PinkScheme,)
            .alpha(0.5F)
        )
        Box(Modifier.size(100.dp)

            .align(Alignment.TopStart)
            .offset((-40).dp,(-10).dp)
            .clip(CircleShape)
            .background(PinkScheme,)
            .alpha(0.2F)
        ) {
            Box(Modifier.size(50.dp)
                .align(Alignment.Center)
                .clip(CircleShape)
                .background(Color.White)
                .alpha(0.8F)
            )
        }
        Box(Modifier.size(180.dp)

            .align(Alignment.TopStart)
            .offset((5).dp,(-95).dp)
            .clip(CircleShape)
            .background(LightPink)
            .alpha(3F)
        )
    }
}

