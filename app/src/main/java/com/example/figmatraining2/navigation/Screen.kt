package com.example.figmatraining2.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route: String){
    data object Root:Screen("root_screen")
    data object Login:Screen("login_screen")
    data object SignUp:Screen("signup_screen")
    data object VerifyCode: Screen("new_password_screen")
    data object ResetPassword: Screen("reset_password_screen")
    data object RegisterNumber: Screen("register_number_screen")
    data object SplashRoute: Screen("splash_screen")
    data object HomeRoute:Screen("home_screen")
}
data object Graph{
    val main="Main_screen"
    val auth="Auth_screen"
    val root="Root_screen"

}
