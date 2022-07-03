package com.raoarsalan.framework.database

import androidx.room.RoomDatabase
import com.raoarsalan.framework.database.dao.NewsDao

abstract class NewsDB : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        const val DATABASE_NAME = "NEWS_DB"
    }
}