package com.test.roomwithmvvmdagger.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.test.roomwithmvvmdagger.Dao.UserDao
import com.test.roomwithmvvmdagger.Entity.User


/*val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE users "
                    + "ADD COLUMN address TEXT"
        )
    }
}*/
@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){

    private var INSTANCE: UserDatabase? = null
    private val DB_NAME = "user"

     /*val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "ALTER TABLE users "
                        + "ADD COLUMN address TEXT"
            )
        }
    }

     fun getDatabase(context: Context): UserDatabase? {
        if (INSTANCE == null) {
            synchronized(UserDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        UserDatabase::class.java, DB_NAME
                    )
                        .addMigrations(MIGRATION_1_2)
                        .build()
                }
            }
        }
        return INSTANCE
    }*/

    abstract fun userDao(): UserDao
    }
