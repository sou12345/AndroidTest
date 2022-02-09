package com.test.roomwithmvvmdagger.module

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.test.roomwithmvvmdagger.Dao.UserDao
import com.test.roomwithmvvmdagger.Database.UserDatabase
import com.test.roomwithmvvmdagger.Repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule  {

    @Provides
    fun providesUserDao(userDatabase: UserDatabase): UserDao = userDatabase.userDao()

    private val MIGRATION_1_2 = object : Migration(1, 2){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `user` (`id` INTEGER, PRIMARY KEY(`id`))")
        }
    }
    @Provides
    @Singleton
    fun providesUserDatabase(@ApplicationContext context: Context): UserDatabase = Room.databaseBuilder(context, UserDatabase::class.java,"user").addMigrations(MIGRATION_1_2).build()

    @Provides
    fun providesUserRepository(userDao: UserDao) : UserRepository
            = UserRepository(userDao)
}