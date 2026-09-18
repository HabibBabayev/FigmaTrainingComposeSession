package com.example.figmatraining2.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmatraining2.R
import com.example.figmatraining2.screen.customUI.CustomBackGroundDecoration
import com.example.figmatraining2.screen.customUI.CustomHeader
import com.example.figmatraining2.screen.customUI.GoBackIconButtonCustom
import com.example.figmatraining2.screen.customUI.SubmitButtonCustom
import com.example.figmatraining2.screen.stateAndEventControl.LoginEvent
import com.example.figmatraining2.screen.stateAndEventControl.LoginState
import com.example.figmatraining2.screen.stateAndEventControl.UiState

import com.example.figmatraining2.ui.theme.PinkScheme
import com.example.figmatraining2.ui.theme.jostRegular
import com.example.figmatraining2.ui.theme.outlinedTextFieldCurves
import com.example.figmatraining2.ui.theme.outlinedTextFieldFocusedBorders
import com.example.figmatraining2.ui.theme.outlinedTextFieldFont
import com.example.figmatraining2.ui.theme.staticInter

@Composable
fun LoginScreen(modifier:Modifier, goBackScreen:()->Unit,
                event:(LoginEvent)->Unit,
                state: LoginState,
                onSubmitClick:()->Unit,
                onForgotPasswordClick:()-> Unit,
                backToSignUp:()-> Unit){
    LaunchedEffect(state.isLoggedIn) {
        if (state.isLoggedIn) onSubmitClick()
    }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    CustomBackGroundDecoration()
    Box(modifier.fillMaxSize()) {
        GoBackIconButtonCustom(modifier = Modifier.background(Color.White,
            shape = RoundedCornerShape(10.dp))
            .align(Alignment.TopStart),
            onGoBackClick = goBackScreen)

        Column(Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
        ) {
            CustomHeader("Login")
            Spacer(Modifier.padding(bottom = 100.dp))
            Column(Modifier.fillMaxWidth()) {

                Column(Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = "E-mail or Name",
                        fontFamily = staticInter,
                        color = Color.Gray.copy(0.8F)
                    )
                    OutlinedTextField(
                        value = state.name,
                        onValueChange = {
                            event(LoginEvent.OnUserNameChange(it))
                        },
                        Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        placeholder = {Text("Your email or Profile Name")},
                        shape = outlinedTextFieldCurves,
                        colors = outlinedTextFieldFocusedBorders(),
                        textStyle = outlinedTextFieldFont

                    )
                }
                Column(Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = "Password",
                        fontFamily = jostRegular,
                        color = Color.Gray.copy(0.8F)
                    )
                    OutlinedTextField(
                        value = state.password,
                        onValueChange = {
                            event(LoginEvent.OnPasswordChange(it))
                        },
                        Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                        ,
                        placeholder = {Text("Password")},
                        colors = outlinedTextFieldFocusedBorders(),
                        shape = outlinedTextFieldCurves,
                        textStyle = outlinedTextFieldFont,
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


                    Column(Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
                        TextButton(onClick = {onForgotPasswordClick()},
                            Modifier.padding(vertical = 10.dp)
                                .align(Alignment.CenterHorizontally),

                            ) {
                            Text(text = "Forgot Password?",
                                fontFamily = jostRegular,
                                fontWeight = FontWeight.W600,
                                color = PinkScheme)
                        }
                        SubmitButtonCustom("SIGN IN", onSubmitClick = {
                            event(LoginEvent.OnLoginClick)
                        })
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Don't have an account?",
                                color = Color.Gray,
                                fontFamily = jostRegular)
                            TextButton(onClick = {backToSignUp()},
                                Modifier.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                                contentPadding = PaddingValues(0.dp),

                                ) {
                                Text(text = "Sign Up",
                                    color = PinkScheme)
                            }
                        }

                    }

                }
                Column(Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        HorizontalDivider(Modifier.weight(0.5f).padding(horizontal = 15.dp), color = Color.Gray)
                        Text(
                            text = "Sign in With",
                            fontFamily = jostRegular,
                            color = Color.Gray,
                            fontWeight = FontWeight.W500,
                            fontSize = 15.sp
                        )
                        HorizontalDivider(Modifier.weight(0.5f).padding(horizontal = 15.dp),color=Color.Gray)

                    }
                    Row(Modifier.fillMaxWidth()
                        .padding(top = 15.dp, start = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        FilledTonalButton (onClick = {},
                            Modifier.width(160.dp),
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
                            Modifier.width(160.dp),
                            contentPadding = PaddingValues(all = 10.dp),
                            colors = ButtonColors(Color.White,
                                Color.Black,
                                Color.White,
                                Color.Black),
                            elevation = ButtonDefaults.filledTonalButtonElevation(0.2.dp)
                        ) {
                            Icon(painter = painterResource(R.drawable.google_icon),
                                contentDescription = "google",
                                Modifier.size(35.dp).padding(start = 0.dp),
                                tint=Color.Unspecified)

                            Text(text="GOOGLE",
                                Modifier.padding(all=10.dp),
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
}
