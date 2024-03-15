package com.feature.category.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope


import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel

import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import feature.categoryDetails.ui.screen.CategoryDetailsScreen
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


object CategoryScreen : Screen {

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
      val viewModel = getViewModel<CategoryViewModel>()
        val result = viewModel.categoryList.value
        val scope = rememberCoroutineScope()


        Column {

            Text(text = "Hello Rahul")
            Button(onClick = {
                viewModel.getCategoryList()
            }) {
                Text(text = "Get List")
            }


            if (result.isLoading) {
                Text(text = "loading")
            }



            if (result.error.isNotBlank()) {
                Text(text = "error ${result.error}")
            }


            result.data?.let {
                Text(text = "First Screen $it")
                Button(onClick = {
                    //navigator.push(CategoryDetailsScreen)
                    navigator.push(CategoryDetailsScreen())
                }) {
                    Text(text = "Goto Second Screen")

                }
            }

            }





        }
    }



@Composable
fun FirstScreen(a:Int) {

}