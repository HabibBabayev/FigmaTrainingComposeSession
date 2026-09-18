package com.example.figmatraining2.api

import com.example.figmatraining2.model.LoginResponseModel
import com.example.figmatraining2.model.request.LoginRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
@POST("auth/login")
suspend fun loginUser(
    @Body user: LoginRequestModel): Response<LoginResponseModel>
}