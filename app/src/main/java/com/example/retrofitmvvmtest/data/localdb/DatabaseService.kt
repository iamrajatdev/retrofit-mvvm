package com.example.retrofitmvvmtest.data.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.retrofitmvvmtest.data.localdb.dao.PageDao
import com.example.retrofitmvvmtest.model.remote.UserService
import com.example.retrofitmvvmtest.model.response.PageResponse
import com.example.retrofitmvvmtest.model.response.UserResponse

@Database(entities = [PageResponse::class], exportSchema = false, version = 1)
@TypeConverters(PageResponse.UserTypeConverters::class)
abstract class DatabaseService : RoomDatabase() {

    companion object {
        private var instance: DatabaseService? = null

        fun getInstance(context: Context): DatabaseService? {
            if (instance == null) {
                synchronized(DatabaseService::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseService::class.java,
                        "pages_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }

    abstract fun pageDao(): PageDao
}