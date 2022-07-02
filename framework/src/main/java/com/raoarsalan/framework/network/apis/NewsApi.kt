package com.raoarsalan.framework.network.apis

import com.raoarsalan.core.domain.ResultResponse
import com.raoarsalan.core.domain.model.response.NewsModel
import com.raoarsalan.framework.commons.ApiEndPoints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    @Headers("Content-Type: application/json")
    @GET(ApiEndPoints.MOST_POPULAR)
    suspend fun getPopularNews(
        @Query("api-key") apiKey: String = "N8x5EIppmwphXT8oGkzmclvkedpeg7j5"
    ): Response<ResultResponse<NewsModel>>
}