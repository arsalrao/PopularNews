package com.raoarsalan.core.data.repository

import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.model.response.ResponseModel

interface NewsRepository {
    suspend fun getPopularNews(): Result<ResponseModel>
}