package com.feature.category.domain.repo

interface CategoryRepo {
suspend fun getCategory():List<String>
}