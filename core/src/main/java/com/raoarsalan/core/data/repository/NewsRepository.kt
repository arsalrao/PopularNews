package com.raoarsalan.core.data.repository

import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.model.response.NewsModel
import com.raoarsalan.core.domain.model.response.ResponseModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getPopularNews(): Flow<Result<ResponseModel>>

    /** locally save/retrieve,delete news data */
    suspend fun getPopularNewsLocally(): List<NewsModel>
    suspend fun savePopularNews(list: List<NewsModel>)
    suspend fun deleteAll()
}