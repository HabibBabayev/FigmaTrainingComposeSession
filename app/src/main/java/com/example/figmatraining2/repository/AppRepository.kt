package com.example.figmatraining2.repository

import com.example.figmatraining2.api.ApiService
import com.example.figmatraining2.general.Resource
import com.example.figmatraining2.model.LoginResponseModel
import com.example.figmatraining2.model.request.LoginRequestModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class AppRepository @Inject constructor(
    val appService: ApiService
) {
    fun getLogin(password: String,userName: String): Flow<Resource<Boolean>> =flow{
        emit(Resource.Loading)
        try {
           val response= appService.loginUser(user = LoginRequestModel(password,userName))
            if (response.isSuccessful){
                response.body()?.let {
                    emit(Resource.Success(true))
                }?:emit(Resource.Error(response.message())
                )
            }else emit(Resource.Error(response.message()))

        } catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }

    }.flowOn(Dispatchers.IO)
}