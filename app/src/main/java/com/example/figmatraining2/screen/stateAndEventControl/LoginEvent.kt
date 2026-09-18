package com.example.figmatraining2.screen.stateAndEventControl

sealed interface LoginEvent {
    data object OnLoginClick: LoginEvent
    data class OnUserNameChange(val name: String): LoginEvent
    data class OnPasswordChange(val password: String): LoginEvent

}