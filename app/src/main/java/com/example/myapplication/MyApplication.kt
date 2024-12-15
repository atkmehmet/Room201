package com.example.myapplication

import android.app.Application
import androidx.room.Room

class MyApplication: Application()
{
    companion object{
        lateinit var userDao: UserDao

    }

    override fun onCreate() {
        super.onCreate()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"UserDatabase"
        ).build()

        userDao = db.userDao()
    }
}