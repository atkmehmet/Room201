package com.example.myapplication

import android.app.Application
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class MyApplication: Application()
{
    companion object{
        lateinit var userDao: UserDao
        lateinit var userService: UserService

    }

    override fun onCreate() {
        super.onCreate()
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .build()
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"UserDatabase"
        ).build()

        userDao = db.userDao()
    }
}