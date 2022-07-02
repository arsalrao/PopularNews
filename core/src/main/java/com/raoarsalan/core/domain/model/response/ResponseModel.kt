package com.raoarsalan.core.domain.model.response

data class ResponseModel(
    val status: String,
    val copyright: String,
    val num_results: Int,
    val results: List<NewsModel>
)