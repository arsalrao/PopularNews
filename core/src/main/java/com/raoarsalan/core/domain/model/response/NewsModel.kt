package com.raoarsalan.core.domain.model.response

data class NewsModel(
    val id: Long,
    val source: String,
    val published_date: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val media: List<MediaModel>?
) {
    fun getArticleImg(): String? {
        return try {
            media?.get(0)?.mediaMeta?.get(0)?.url
        } catch (e: IndexOutOfBoundsException) {
            null
        }
    }
}