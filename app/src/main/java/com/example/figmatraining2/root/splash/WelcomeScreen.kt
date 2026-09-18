package com.example.figmatraining2.root.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.figmatraining2.R
import com.example.figmatraining2.ui.theme.PinkScheme

import com.example.figmatraining2.ui.theme.openSans
import com.example.figmatraining2.ui.theme.poppinBold

@Composable
fun WelcomeScreen(modifier: Modifier,onSkipClick:()-> Unit,onLogInClick:()-> Unit,onSignUpClick:()-> Unit){
    Image(painter = painterResource(id=R.drawable.breakfast2),
        contentDescription = "background_pic",
        Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,

        )
    Column(Modifier.fillMaxSize().zIndex(1f)
        .background(brush = Brush.verticalGradient(
            listOf(
                Color.White.copy(0.3F),
                Color.DarkGray.copy(0.5F),
                Color.Black.copy()
            )
        ))
    ){
        Column(modifier.fillMaxSize().padding()) {
            Box(Modifier.fillMaxWidth()) {

                FilledTonalButton(onClick = onSkipClick,
                    Modifier.align(Alignment.TopEnd),
                    elevation = ButtonDefaults.buttonElevation(10.dp,
                        0.dp,
                        20.dp,
                        15.dp,
                        10.dp)
                ) {
                    Text(text = "Skip",
                        color=PinkScheme,
                        fontFamily = openSans,
                        fontWeight = FontWeight.Bold

                        )
                }
                Column(Modifier.padding(top = 120.dp)) {
                    Text(text = "Welcome",
                        fontSize = 50.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W700,
                        fontFamily= poppinBold
                    )
                    Text(text = "FoodHub",
                        color = PinkScheme,
                        fontSize = 50.sp,
                        fontFamily = poppinBold,
                        fontWeight = FontWeight.W700)
                    Text(text ="Your favourite foods delivered fast at your door.",
                        Modifier.zIndex(2f),
                        overflow = TextOverflow.StartEllipsis,
                        fontFamily = openSans,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray

                    )
                }

            }
            Spacer(Modifier.height(70.dp))

            Column(Modifier.fillMaxWidth().padding(top = 150.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    HorizontalDivider(Modifier.weight(0.5f).padding(horizontal = 15.dp), color = Color.White)
                    Text(
                        text = "Sign in With",
                        fontFamily = openSans,
                        color = Color.White,
                        fontWeight = FontWeight.W600
                    )
                    HorizontalDivider(Modifier.weight(0.5f).padding(horizontal = 15.dp),color=Color.White)

                }
                Row(Modifier.fillMaxWidth()
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    FilledTonalButton (onClick = {},
                        Modifier.width(160.dp),
                        contentPadding = PaddingValues(10.dp),


                    ) {
                        Icon(painter = painterResource(R.drawable.facebook_icon),
                            contentDescription = "facebook",
                            Modifier.size(40.dp).padding(start = 0.dp),
                            tint=Color.Unspecified)

                        Text(text="FACEBOOK",
                            Modifier.padding(10.dp),
                            fontFamily =FontFamily.SansSerif,
                            fontWeight = FontWeight.W400,
                            color=Color.Black,
                            )
                    }
                    FilledTonalButton (onClick = {},
                        Modifier.width(160.dp),
                        contentPadding = PaddingValues(10.dp),

                        ) {
                        Icon(painter = painterResource(R.drawable.google_icon),
                            contentDescription = "google",
                            Modifier.size(38.dp).padding(start = 0.dp),
                            tint=Color.Unspecified)

                        Text(text="GOOGLE",
                            Modifier.padding(10.dp),
                            fontFamily =FontFamily.SansSerif,
                            fontWeight = FontWeight.W400,
                            color=Color.Black,
                        )
                    }
                }
                OutlinedButton(onClick = {onSignUpClick()},
                                Modifier.fillMaxWidth()
                                    .padding(top = 20.dp, start = 10.dp, end = 10.dp)
                                    .height(60.dp),
                                colors = ButtonColors(containerColor = Color.White.copy(0.2F),Color.White,Color.White.copy(0.5F),Color.Black)
                                ) {
                    Text(text = "Start with email or phone",
                        fontSize = 18.sp,
                        color=Color.White,
                        textAlign = TextAlign.Center,
                        fontFamily = openSans,
                        fontWeight = FontWeight.W600,

                        )
                }
                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,) {
                    Text(text = "Already have an account?",
                        color=Color.White,
                        fontFamily = openSans,
                        fontWeight = FontWeight.W500)
                    TextButton(onClick = {onLogInClick()}) {
                        Text(text="Sign in",
                            textDecoration = TextDecoration.Underline,
                            color=Color.White,
                            fontFamily = openSans,
                            fontWeight = FontWeight.W500) }
                }

            }
        }
    }

}