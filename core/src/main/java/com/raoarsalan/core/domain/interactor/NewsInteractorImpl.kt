package com.raoarsalan.core.domain.interactor

import com.raoarsalan.core.data.repository.NewsRepository
import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.model.response.NewsModel
import com.raoarsalan.core.domain.model.response.ResponseModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsInteractorImpl @Inject constructor(private val newsRepo: NewsRepository) :
    NewsInteractor {
    override suspend fun getPopularNews(): Flow<Result<ResponseModel>> {
        return newsRepo.getPopularNews()
    }

    override suspend fun getPopularNewsLocally(): List<NewsModel> {
        return newsRepo.getPopularNewsLocally()
    }

    override suspend fun savePopularNews(list: List<NewsModel>) {
        newsRepo.savePopularNews(list)
    }

    override suspend fun deleteAll() {
        newsRepo.deleteAll()
    }
}