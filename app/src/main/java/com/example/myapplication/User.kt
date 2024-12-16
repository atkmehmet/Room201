package com.example.myapplication

import com.squareup.moshi.Json


data class User(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "username") val username: String
)
