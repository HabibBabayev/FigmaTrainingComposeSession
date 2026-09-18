package com.example.figmatraining2.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

import com.example.figmatraining2.R
import com.example.figmatraining2.ui.theme.PinkScheme

@Composable
fun SplashScreen(){
    Column(Modifier.fillMaxSize()
        .background(PinkScheme),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Icon(imageVector = ImageVector.vectorResource(R.drawable.group_18118), contentDescription = null,
            tint = Color.Unspecified)
    }
}