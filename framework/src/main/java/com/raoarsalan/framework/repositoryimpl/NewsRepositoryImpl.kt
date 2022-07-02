package com.raoarsalan.framework.repositoryimpl

import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.ResultResponse
import com.raoarsalan.core.domain.data.repository.NewsRepository
import com.raoarsalan.core.domain.model.response.NewsModel
import com.raoarsalan.framework.network.apis.NewsApi
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {
    override suspend fun getPopularNews(): Result<ResultResponse<NewsModel>> {
        TODO("Not yet implemented")
    }
}