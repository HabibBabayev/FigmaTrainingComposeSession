package com.example.figmatraining2.model.request

import com.google.gson.annotations.SerializedName

data class LoginRequestModel(
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)