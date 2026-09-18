package com.example.figmatraining2.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.figmatraining2.R
import com.example.figmatraining2.screen.customUI.CustomBackGroundDecoration
import com.example.figmatraining2.screen.customUI.CustomHeader
import com.example.figmatraining2.screen.customUI.SubmitButtonCustom
import com.example.figmatraining2.ui.theme.Ivory
import com.example.figmatraining2.ui.theme.PinkScheme
import com.example.figmatraining2.ui.theme.jostRegular
import com.example.figmatraining2.ui.theme.outlinedTextFieldCurves
import com.example.figmatraining2.ui.theme.outlinedTextFieldFocusedBorders
import com.example.figmatraining2.ui.theme.outlinedTextFieldFont
import com.example.figmatraining2.ui.theme.staticInter

@Composable
fun SignUpScreen(modifier: Modifier,onLoginClick:()-> Unit,onSubmitClick:()-> Unit){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxSize()
        .background(Ivory),
         ) {
        CustomBackGroundDecoration()
        Column(modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            ) {

            Column(Modifier.fillMaxWidth()) {
                CustomHeader("Sign Up")
                Spacer(Modifier.padding(bottom = 100.dp))
                Column(Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(2.dp)) {

                    Column(Modifier.fillMaxWidth()) {
                        Text(text = "Full Name",
                            fontFamily = staticInter,
                            color = Color.LightGray
                        )
                        OutlinedTextField(
                            value = name,
                            onValueChange = {
                                name=it
                            },
                            Modifier
                                .height(60.dp)
                                .fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray.copy(0.2F),
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            colors = outlinedTextFieldFocusedBorders(),
                            textStyle = outlinedTextFieldFont,
                            shape = outlinedTextFieldCurves
                        )
                    }
                    Column(Modifier.fillMaxWidth()) {
                        Text(text = "E-mail",
                            fontFamily = staticInter,
                            color = Color.LightGray
                        )
                        OutlinedTextField(
                            value = email,
                            onValueChange = {
                                email=it
                            },
                            Modifier
                                .height(60.dp)
                                .fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray.copy(0.2F),
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            colors = outlinedTextFieldFocusedBorders(),
                            textStyle = outlinedTextFieldFont,
                            shape = outlinedTextFieldCurves
                        )
                    }
                    Column(Modifier.fillMaxWidth()) {
                        Text(text = "Password",
                            fontFamily = jostRegular,
                            color = Color.LightGray
                        )
                        OutlinedTextField(
                            value = password,
                            onValueChange = {
                                password=it
                            },
                            Modifier
                                .height(60.dp)
                                .fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray.copy(0.2F),
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            colors = outlinedTextFieldFocusedBorders(),
                            textStyle = outlinedTextFieldFont,
                            shape = outlinedTextFieldCurves,
                            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                if (isPasswordVisible){
                                    IconButton(onClick = {isPasswordVisible=!isPasswordVisible},
                                        content={
                                            Icon(painter = painterResource(R.drawable.eye_on),
                                                contentDescription = null,
                                                tint = Color.LightGray,)
                                        }
                                    )
                                }else{
                                    IconButton(onClick = {isPasswordVisible=!isPasswordVisible},
                                        content={
                                            Icon(painter = painterResource(R.drawable.eye_off),
                                                contentDescription = null,
                                                tint = Color.LightGray,)
                                        }
                                    )
                                }

                            }

                        )
                    }
            }


                Spacer(Modifier.height(30.dp))
                Column(Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
                    SubmitButtonCustom("SIGN UP",onSubmitClick=onSubmitClick)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Already have an account?",
                            color = Color.DarkGray)
                        TextButton(onClick = {onLoginClick()},
                            Modifier.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                            contentPadding = PaddingValues(0.dp),

                            ) {
                            Text(text = "Login",
                                color = PinkScheme)
                        }
                    }

                }

            }
            Column(Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    HorizontalDivider(Modifier.weight(0.5f).padding(horizontal = 15.dp), color = Color.Gray)
                    Text(
                        text = "Sign up With",
                        fontFamily = jostRegular,
                        color = Color.Gray,
                        fontWeight = FontWeight.W600
                    )
                    HorizontalDivider(Modifier.weight(0.5f).padding(horizontal = 15.dp),color=Color.Gray)

                }
                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    FilledTonalButton (onClick = {},
                        Modifier.width(160.dp)
                            .alpha(2F),
                        contentPadding = PaddingValues(10.dp),
                        colors = ButtonColors(Color.White,
                            Color.Black,
                            Color.White,
                            Color.Black),
                        elevation = ButtonDefaults.filledTonalButtonElevation(0.2.dp)
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
                        Modifier.width(160.dp)
                            .alpha(2F),
                        contentPadding = PaddingValues(10.dp),

                        elevation = ButtonDefaults.filledTonalButtonElevation(0.2.dp),
                        colors = ButtonColors(Color.White,
                            Color.Black,
                            Color.White,
                            Color.Black)
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



            }

        }
    }


}