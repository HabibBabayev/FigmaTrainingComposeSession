package com.example.figmatraining2.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmatraining2.screen.customUI.CustomBackGroundDecoration
import com.example.figmatraining2.screen.customUI.CustomHeader
import com.example.figmatraining2.screen.customUI.GoBackIconButtonCustom
import com.example.figmatraining2.ui.theme.PinkScheme


@Composable
fun VerificationScreen(goBackScreen:()-> Unit,modifier: Modifier){
    CustomBackGroundDecoration()
    Box(modifier.fillMaxSize()) {
    GoBackIconButtonCustom(modifier = Modifier.background(Color.White,
        shape = RoundedCornerShape(10.dp))
        .align(Alignment.TopStart),
        onGoBackClick = goBackScreen)
    Column(Modifier.fillMaxWidth()
        .align(Alignment.Center)) {
        Column(Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)){

            CustomHeader("Verification code")
            Text("Please write code that send to your email",
                color = Color.Gray,
                fontSize = 12.sp)
            CodeEntrySample(modifier = Modifier)

            Row(Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(text = "I don't receive a code")
                TextButton(onClick = {}) {
                    Text("Please resend",
                        color = PinkScheme, fontWeight = FontWeight.Bold
                    )
                }
        }
        }
    }
}
    }


@Composable
fun CodeEntrySample(countBy: Int=4,modifier: Modifier){
    //to track entered digits
    val digits = remember { mutableStateListOf(*Array(countBy){""}) }
    val focusRequest =remember { List(countBy){ FocusRequester() } }

    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceAround
    ) {
        digits.forEachIndexed { index, digit ->
            OutlinedTextField(value = digit,
            onValueChange = {newNumber->
                //if entered number is one and it is only digit
                if (newNumber.length<=1 && newNumber.all { it.isDigit() })
                    digits[index]=newNumber
                if (newNumber.isNotEmpty() && index <countBy-1)
                    focusRequest[index+1].requestFocus()
            },
                Modifier.size(55.dp)
                    .focusRestorer(focusRequest[index]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = if (index == countBy - 1) ImeAction.Done else ImeAction.Next
                ),
                textStyle = TextStyle(
                    color = PinkScheme,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PinkScheme,
                    unfocusedBorderColor = Color.LightGray
                ),
                shape = ShapeDefaults.Medium
                )
        }
    }
}