package com.example.figmatraining2.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.figmatraining2.R
import com.example.figmatraining2.screen.customUI.CustomBackGroundDecoration
import com.example.figmatraining2.screen.customUI.CustomHeader
import com.example.figmatraining2.screen.customUI.CustomText
import com.example.figmatraining2.screen.customUI.GoBackIconButtonCustom
import com.example.figmatraining2.screen.customUI.SubmitButtonCustom
import com.example.figmatraining2.ui.theme.outlinedTextFieldCurves
import com.example.figmatraining2.ui.theme.outlinedTextFieldFocusedBorders
import com.example.figmatraining2.ui.theme.outlinedTextFieldFont

@Composable
fun RegNumScreen(modifier: Modifier,onSendClick:()-> Unit, onGoBack:()-> Unit) {
    var number by remember { mutableStateOf("") }
    CustomBackGroundDecoration()
    Box(modifier.fillMaxSize()) {
        GoBackIconButtonCustom(Modifier.background(Color.White,
            shape = RoundedCornerShape(10.dp))
            .align(Alignment.TopStart), onGoBackClick = onGoBack)
        Column(modifier.fillMaxWidth()
            .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Column(Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)) {
                CustomHeader("Registration")
                CustomText(text = R.string.registerNumber_exp_txt)
                OutlinedTextField(
                    value = number,
                    onValueChange = {
                        number = it
                    },
                    Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    placeholder = { Text("") },
                    shape = outlinedTextFieldCurves,
                    colors = outlinedTextFieldFocusedBorders(),
                    textStyle = outlinedTextFieldFont

                )
            }
            Spacer(Modifier.height(40.dp))
            SubmitButtonCustom("SEND", onSubmitClick = onSendClick)
        }

    }
}