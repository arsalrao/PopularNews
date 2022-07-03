package com.raoarsalan.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.raoarsalan.framework.database.converters.MediaModelConverter
import com.raoarsalan.framework.database.dao.NewsDao
import com.raoarsalan.framework.database.entitiy.NewsEntity

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
@TypeConverters(MediaModelConverter::class)
abstract class NewsDB : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        const val DATABASE_NAME = "NEWS_DB"
    }
}