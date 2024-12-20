package com.example.myapplication


import android.app.Application
import androidx.room.Room
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class MyApplication:Application() {
    companion object {
        lateinit var service: UserService
        lateinit var userDao: UserDao
    }
    override fun onCreate() {
        super.onCreate()

        val okHttpClient = OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"my-database"
        ).build()
        userDao = db.userDao()

        service = retrofit.create(UserService::class.java)


    }


}