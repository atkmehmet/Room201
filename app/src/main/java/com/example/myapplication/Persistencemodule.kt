package com.example.myapplication

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class Persistencemodule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):AppDatabase =Room.databaseBuilder(
        context,
        AppDatabase::class.java,"my-database"
    ).build()

    @Provides
    fun provideUserDao(appDatabase: AppDatabase) :UserDao = appDatabase.userDao()


}