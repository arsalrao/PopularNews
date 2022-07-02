package com.raoarsalan.framework.repositoryimpl

import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.ResultResponse
import com.raoarsalan.core.domain.data.repository.NewsRepository
import com.raoarsalan.core.domain.model.response.NewsModel
import com.raoarsalan.framework.network.ApiCall
import com.raoarsalan.framework.network.apis.NewsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {
    override suspend fun getPopularNews(): Result<ResultResponse<NewsModel>> {
        return withContext(Dispatchers.IO) {
            return@withContext ApiCall.result {
                api.getPopularNews()
            }
        }
    }
}