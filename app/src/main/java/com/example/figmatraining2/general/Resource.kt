package com.example.figmatraining2.general

sealed class Resource<out T> {
    data object Loading: Resource<Nothing>()
    data class Success<out T>(val data:T): Resource<T>()
    data class Error(val message: String): Resource<Nothing>()
}