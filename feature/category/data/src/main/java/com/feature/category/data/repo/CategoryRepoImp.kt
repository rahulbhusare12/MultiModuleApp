package com.feature.category.data.repo

import com.feature.category.data.network.CategoryApi
import com.feature.category.domain.repo.CategoryRepo
import javax.inject.Inject


class CategoryRepoImp @Inject constructor(private val categoryApi: CategoryApi) : CategoryRepo {
    override suspend fun getCategory(): List<String> {
        return categoryApi.getCategory()
    }
}