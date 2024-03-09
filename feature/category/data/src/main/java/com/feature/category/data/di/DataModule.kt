package com.feature.category.data.di

import com.feature.category.data.network.CategoryApi
import com.feature.category.data.repo.CategoryRepoImp
import com.feature.category.domain.repo.CategoryRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    fun provideCategoryApi(): CategoryApi {
        return Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoryApi::class.java)
    }
    @Provides
    fun provideCategoryRepo(categoryApi: CategoryApi): CategoryRepo {
        return CategoryRepoImp(categoryApi)
    }
}

