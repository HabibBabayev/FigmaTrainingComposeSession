package com.example.figmatraining2.screen.auth

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.figmatraining2.navigation.Graph
import com.example.figmatraining2.navigation.Screen
import com.example.figmatraining2.screen.stateAndEventControl.LoginEvent
import com.example.figmatraining2.screen.stateAndEventControl.LoginState


fun NavGraphBuilder.authNavigation(navController: NavController, loginState:LoginState, loginEvent: (LoginEvent)->Unit, modifier: Modifier){
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
                }, state = loginState, event = {loginEvent}, onForgotPasswordClick = {
                    navController.navigate(Screen.ResetPassword.route)
                }, onSubmitClick = {navController.navigate(Graph.main)} ,backToSignUp = {
                    navController.popBackStack()
                })

            }
            composable(route= Screen.VerifyCode.route){
                VerificationScreen( goBackScreen = {
                    navController.popBackStack()
                },
                    modifier=modifier,)

        }
        composable(route= Screen.ResetPassword.route) {
            ResetPasswordScreen(modifier=modifier, onGoBack = {
                navController.popBackStack()
            }, onSubmitClick = {
                navController.navigate(Screen.RegisterNumber.route)
            })
        }
        composable(route=Screen.RegisterNumber.route){
            RegNumScreen(modifier=modifier, onSendClick = {
                navController.navigate(route= Screen.VerifyCode.route)
            },
                onGoBack = {
                    navController.popBackStack()
                })
        }
    }

}