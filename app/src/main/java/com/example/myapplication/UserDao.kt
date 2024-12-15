package com.example.myapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("Select * from user ")
    fun getAll():Flow<List<UserEntity>>


    @Insert
    fun insert(vararg users:List<UserEntity>)

}