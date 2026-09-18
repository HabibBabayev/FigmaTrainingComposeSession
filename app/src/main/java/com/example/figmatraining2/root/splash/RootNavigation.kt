package com.example.figmatraining2.root.splash

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.figmatraining2.main.HomeScreen
import com.example.figmatraining2.navigation.Graph
import com.example.figmatraining2.navigation.Screen
import kotlinx.coroutines.delay
import androidx.compose.ui.Modifier

fun NavGraphBuilder.rootNavigation(navController: NavController,modifier: Modifier){
    navigation(startDestination = Screen.SplashRoute.route,route= Graph.root){
        composable(route= Screen.Root.route){
            WelcomeScreen(modifier=modifier,
                onSkipClick = {
                    navController.navigate(route = Screen.HomeRoute.route){
                        popUpTo (Screen.Root.route, popUpToBuilder = {
                            inclusive=true
                        } )
                    }
                },
                onLogInClick = {
                    navController.navigate(route = Screen.Login.route){
                        popUpTo (Screen.Root.route, popUpToBuilder = {
                            inclusive=true
                        } )
                    }
                },
                onSignUpClick = {
                    navController.navigate(route= Screen.SignUp.route){
                        popUpTo (Screen.Root.route, popUpToBuilder = {
                            inclusive=true
                        } )
                    }
                }
            )
        }
        composable(route = Screen.SplashRoute.route){
            SplashScreen()
            LaunchedEffect(Unit) {
                delay(3000)
                navController.navigate(route= Screen.Root.route){
                    popUpTo(route=Screen.SplashRoute.route, popUpToBuilder = {inclusive=true})
                }
            }
        }

    }

}