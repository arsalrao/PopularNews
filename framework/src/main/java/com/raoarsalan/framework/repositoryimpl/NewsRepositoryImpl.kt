package com.raoarsalan.framework.repositoryimpl

import com.raoarsalan.core.data.repository.NewsRepository
import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.model.response.NewsModel
import com.raoarsalan.core.domain.model.response.ResponseModel
import com.raoarsalan.framework.database.dao.NewsDao
import com.raoarsalan.framework.database.mappers.toDomain
import com.raoarsalan.framework.database.mappers.toEntity
import com.raoarsalan.framework.network.ApiCall
import com.raoarsalan.framework.network.apis.NewsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val dao: NewsDao
) : NewsRepository {
    override suspend fun getPopularNews(): Flow<Result<ResponseModel>> {
        return flow {
            emit(
                ApiCall.result {
                    api.getPopularNews()
                }
            )
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getPopularNewsLocally(): List<NewsModel> {
        return withContext(Dispatchers.IO) {
            dao.getPopularNews().toDomain()
        }
    }

    override suspend fun savePopularNews(list: List<NewsModel>) {
        withContext(Dispatchers.IO) {
            dao.insertAll(list.toEntity())
        }
    }

    override suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            dao.deleteAll()
        }
    }
}