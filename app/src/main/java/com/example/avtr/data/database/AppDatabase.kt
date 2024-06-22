package com.example.avtr.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserDbModel::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appService(): AppDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val LAN = Any()
        private var dbName = "obmen.db"
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE != null) {
                INSTANCE?.let {
                    return it
                }
            }
            synchronized(LAN) {
                INSTANCE?.let {
                    return it
                }
            }
            val db = Room.databaseBuilder(context, AppDatabase::class.java, dbName)
                .allowMainThreadQueries().build()
            INSTANCE = db
            return db
        }
    }
}