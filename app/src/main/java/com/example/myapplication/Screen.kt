package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun Users(navController: NavController,viewModel: MainViewModel = viewModel(factory = MainViewFactory())){

    UserList(users = viewModel.resulState,navController)
}