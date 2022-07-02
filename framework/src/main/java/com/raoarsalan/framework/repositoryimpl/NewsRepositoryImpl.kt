package com.raoarsalan.framework.repositoryimpl

import com.raoarsalan.core.data.repository.NewsRepository
import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.model.response.ResponseModel
import com.raoarsalan.framework.network.ApiCall
import com.raoarsalan.framework.network.apis.NewsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {
    override suspend fun getPopularNews(): Result<ResponseModel> {
        return withContext(Dispatchers.IO) {
            return@withContext ApiCall.result {
                api.getPopularNews()
            }
        }
    }
}