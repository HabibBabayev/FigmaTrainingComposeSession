package com.example.figmatraining2.screen.stateAndEventControl

data class UiState(
    val loading: Boolean=false,
    val error: String?=null
)
data class LoginState(
    val loading: Boolean=false,
    val isLoggedIn: Boolean=false,
    val name: String="",
    val password: String="",
    val error: String?="",
    val email: String=""
)
