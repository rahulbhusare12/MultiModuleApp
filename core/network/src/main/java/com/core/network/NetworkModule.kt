package com.core.network


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
/*
@InstallIn(SingletonComponent::class)
@Module
object NetworkModule{
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}*/
/*

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
*/
