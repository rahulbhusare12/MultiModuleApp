package com.feature.category.domain.useCase

import android.util.Log
import com.core.common.UiEvent
import com.feature.category.domain.repo.CategoryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class GetCategoryUseCase @Inject constructor (private val categoryRepo: CategoryRepo) {
    val  Tag ="USE_CASE"

    operator fun invoke() = flow<UiEvent<List<String>>> {
       emit(UiEvent.Loading())
        Log.d(Tag,"load")
        emit(UiEvent.Success(categoryRepo.getCategory()))
        Log.d(Tag,"call")
    }.catch {
        Log.d(Tag,"EROR")
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}