package com.raoarsalan.core.domain.interactor

import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.ResultResponse
import com.raoarsalan.core.domain.model.response.NewsModel

interface NewsInteractor {
    suspend fun getPopularNews(): Result<ResultResponse<NewsModel>>
}