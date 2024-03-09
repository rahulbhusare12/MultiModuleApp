package com.feature.category.data.network

import retrofit2.http.GET

interface CategoryApi {
    @GET("products/categories")
    suspend fun getCategory(): List<String>
}