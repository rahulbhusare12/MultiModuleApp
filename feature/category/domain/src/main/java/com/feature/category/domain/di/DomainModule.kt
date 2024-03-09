package com.feature.category.domain.di

import com.feature.category.domain.repo.CategoryRepo
import com.feature.category.domain.useCase.GetCategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideCategoryUseCase(categoryRepo: CategoryRepo):GetCategoryUseCase{
        return GetCategoryUseCase(categoryRepo)
    }

}
/*

val categoryDomainModule= module {

    single {
        GetCategoryUseCase(get())
    }
}*/
