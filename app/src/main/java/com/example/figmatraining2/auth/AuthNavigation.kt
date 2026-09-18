package com.example.figmatraining2.auth

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.GraphicsContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.figmatraining2.navigation.Graph
import com.example.figmatraining2.navigation.Screen
import com.example.figmatraining2.root.splash.WelcomeScreen


fun NavGraphBuilder.authNavigation(navController: NavController,modifier: Modifier){
    navigation(startDestination = Screen.SignUp.route,route= Graph.auth){

            composable(route=Screen.SignUp.route){
                SignUpScreen(modifier=modifier,
                    onLoginClick = {navController.navigate(Screen.Login.route)},
                    onSubmitClick = { navController.navigate(Graph.main)}
                )
            }
            composable(route=Screen.Login.route){
                LoginScreen(modifier=modifier, goBackScreen = {
                    navController.popBackStack()//back to the screen where it came from
                }, onForgotPasswordClick = {
                    navController.navigate(Screen.ForgotPassword.route)
                }, onLoginClick = {
                    navController.navigate(Screen.HomeRoute.route){
                        popUpTo(route = Screen.Login.route, popUpToBuilder = {
                            inclusive=true
                        })
                    }

                },
                    backToSignUp = {
                        navController.navigate(Graph.auth)
                    })

            }
            composable(route= Screen.ForgotPassword.route){
                ForgotPasswordScreen( goBackScreen = {
                    navController.popBackStack()
                },
                    modifier=modifier)

        }
    }

}