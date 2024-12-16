package com.example.myapplication

import retrofit2.http.GET


interface UserService {

    @GET("/users")
    suspend  fun getUsers():List<User>

}