package com.example.myapplication


private const val ROUTE_USERS = "users"
private const val ROUTE_USER = "user/%s"
private const val ARG_USER_NAME = "name"
sealed class AppNavigation(val route: String, val argumentName:String = "") {

    object Users : AppNavigation(ROUTE_USER)

    object Useer : AppNavigation(String.format(ROUTE_USER,"{$ARG_USER_NAME}"), ARG_USER_NAME){
        fun routeForName(name:String){
            String.format(ROUTE_USER,name)
        }
    }
}