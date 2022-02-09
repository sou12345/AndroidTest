package com.test.roomwithmvvmdagger.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.roomwithmvvmdagger.Dao.UserDao
import com.test.roomwithmvvmdagger.Entity.User


@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    }
