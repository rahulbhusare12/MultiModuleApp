package com.feature.category.ui.screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feature.category.domain.useCase.GetCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn

import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(private val getCategoryUseCase: GetCategoryUseCase) :
    ViewModel() {
        val Tag ="VM_STATE"
    private val _categoryState = mutableStateOf(CategoryState())
    val categoryList: State<CategoryState> = _categoryState
    val sharedFlow= MutableSharedFlow<Int>()

    init {
        getCategoryList()
    }

    suspend fun updateFlow(){
        repeat(10){
            delay(1000)
            sharedFlow.emit(it)
        }
    }


    fun getCategoryList() = viewModelScope.launch {
        Log.d(Tag,"rr ")

        getCategoryUseCase().onEach {
            Log.d(Tag,"hhhhh ")
            when(it){
                is com.core.common.UiEvent.Error -> {
                    Log.d(Tag,"Error $it.message.toString() ")
                    _categoryState.value = CategoryState(error = it.message.toString())
                }
                is com.core.common.UiEvent.Loading -> {
                    Log.d(Tag,"Loading  ")

                    _categoryState.value = CategoryState(isLoading = true)

                }
                is com.core.common.UiEvent.Success -> {
                    Log.d(Tag,"success ${it.data} ")

                    _categoryState.value= CategoryState(data = it.data)
                }
            }

        }.launchIn(this)
    }
}