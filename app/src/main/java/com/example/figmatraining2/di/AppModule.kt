package com.example.figmatraining2.di

import com.example.figmatraining2.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton
import kotlin.jvm.java


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit{
         val BASE_URL="https://dummyjson.com/"
        val retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        return retrofit
    }
    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit): ApiService{
        val api=retrofit.create(ApiService::class.java)
        return api
    }
}