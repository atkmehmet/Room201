package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.composable


@Composable
fun App(navController: NavHostController){

    NavHost(navController,startDestination = AppNavigation.Users.route){
        composable(route = AppNavigation.Users.route){

            Screen(navController)
        }
        composable(
            route = AppNavigation.User.route,
            arguments = listOf(navArgument(AppNavigation.User.argumentName){
                type = NavType.StringType
            })
        ){
            User(it.arguments?.getString(AppNavigation.User.argumentName).orEmpty())
        }
    }
}
