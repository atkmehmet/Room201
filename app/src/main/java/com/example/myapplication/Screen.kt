package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Screen(viewModel: MainViewModel = viewModel(factory = MainViewFactory())){

    UserList(users = viewModel.resulState)
}