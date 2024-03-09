package com.feature.category.ui.screen

data class CategoryState(

    val isLoading:Boolean=false,
    val data:List<String>?=null,
    val error:String =""
)
