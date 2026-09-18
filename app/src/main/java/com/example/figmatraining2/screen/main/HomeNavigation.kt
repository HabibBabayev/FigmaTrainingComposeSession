package com.example.figmatraining2.screen.main

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.figmatraining2.navigation.Graph
import com.example.figmatraining2.navigation.Screen


fun NavGraphBuilder.homeNavigation(navController: NavController,modifier: Modifier){
    navigation(startDestination = Screen.HomeRoute.route,route= Graph.main){
        composable(route= Screen.HomeRoute.route){
            HomeScreen(modifier = modifier)
        }
    }

}