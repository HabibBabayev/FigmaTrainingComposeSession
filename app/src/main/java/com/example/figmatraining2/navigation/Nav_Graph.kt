package com.example.figmatraining2.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.figmatraining2.screen.auth.LoginViewModel

import com.example.figmatraining2.screen.auth.authNavigation
import com.example.figmatraining2.screen.main.homeNavigation

import com.example.figmatraining2.screen.splash.rootNavigation



@Composable
fun App_Graph(){
    val navController=rememberNavController()
    val viewModel: LoginViewModel = hiltViewModel()
    val state=viewModel.uiState.collectAsState()

    Scaffold {contentPadding->
        NavHost(
            navController=navController,
            startDestination = Graph.root
        ){
           rootNavigation(navController,modifier = Modifier.padding(contentPadding).padding(horizontal = 32.dp))
            authNavigation(navController, loginState=state.value, loginEvent = viewModel::onLogInEvent,modifier = Modifier.padding(contentPadding).padding(horizontal = 32.dp))
            homeNavigation(navController, modifier = Modifier.padding(contentPadding))

        }
    }

}
//@Composable
//fun Nav_Graph(modifier: Modifier,navController: NavHostController= rememberNavController()){
//    NavHost(navController=navController, startDestination = Graph.root, route = Screen.Root.route){
//        navigation(startDestination = Screen.Root.route, route = Graph.root){
//            composable(route= Screen.Root.route){
//                WelcomeScreen(
//                    onSkipClick = {
//                    navController.navigate(route = Graph.main){
//                        popUpTo ( Graph.root, popUpToBuilder = {
//                            inclusive=true
//                        } )
//                    }
//                },
//                    onLogInClick = {
//                    navController.navigate(route = Screen.Login.route){
//                        popUpTo ( Graph.root, popUpToBuilder = {
//                            inclusive=true
//                        } )
//                    }
//                },
//                    onSignUpClick = {
//                    navController.navigate(route= Screen.SignUp.route){
//                        popUpTo ( Graph.root, popUpToBuilder = {
//                            inclusive=true
//                        } )
//                    }
//                }
//                )
//            }
//        }
//        navigation(route = Graph.auth, startDestination = Screen.Login.route){
//            composable(route=Screen.SignUp.route){
//                SignUpScreen()
//            }
//            composable(route=Screen.Login.route){
//                LoginScreen( goBackScreen = {
//                    navController.popBackStack()//back to the screen where it came from
//                }, onForgotPasswordClick = {
//                    navController.navigate(Screen.ForgotPassword.route)
//                },
//                    onLoginClick = {navController.navigate(Screen.Login.route)})
//
//            }
//            composable(route= Screen.ForgotPassword.route){
//                ForgotPasswordScreen( goBackScreen = {
//                    navController.popBackStack()
//                })
//            }
//        }
//
//    }
//}