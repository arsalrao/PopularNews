package com.raoarsalan.core.data.repository

import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.ResultResponse
import com.raoarsalan.core.domain.model.response.NewsModel

interface NewsRepository {
    suspend fun getPopularNews(): Result<ResultResponse<NewsModel>>
}