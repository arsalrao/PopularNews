package com.raoarsalan.framework.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raoarsalan.framework.database.entitiy.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM popularNews")
    suspend fun getPopularNews(): List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: NewsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(popularNewsList: List<NewsEntity>)

    @Query("DELETE FROM popularNews")
    suspend fun deleteAll()
}