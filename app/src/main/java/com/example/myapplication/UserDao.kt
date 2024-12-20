package com.example.myapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("Select * from user ")
    fun getAll():Flow<List<UserEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( users:List<UserEntity>)

}