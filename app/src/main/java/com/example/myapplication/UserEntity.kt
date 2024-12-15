package com.example.myapplication

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity (
     @PrimaryKey @ColumnInfo(name = "id") val id :Long,
     @ColumnInfo(name = "name") val name: String,
     @ColumnInfo(name = "surname") val surname:String,
     @ColumnInfo(name = "email") val email: String
)
