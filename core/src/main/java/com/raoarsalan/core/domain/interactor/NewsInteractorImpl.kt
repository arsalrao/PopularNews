package com.raoarsalan.core.domain.interactor

import com.raoarsalan.core.data.repository.NewsRepository
import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.model.response.ResponseModel
import javax.inject.Inject

class NewsInteractorImpl @Inject constructor(private val newsRepo: NewsRepository) :
    NewsInteractor {
    override suspend fun getPopularNews(): Result<ResponseModel> {
        return newsRepo.getPopularNews()
    }
}