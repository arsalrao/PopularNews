package com.raoarsalan.core.domain.interactor

import com.raoarsalan.core.domain.Result
import com.raoarsalan.core.domain.model.response.ResponseModel

interface NewsInteractor {
    suspend fun getPopularNews(): Result<ResponseModel>
}