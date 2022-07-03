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
    /** return thumbnail image of news with 75x75 **/
    fun thumbnailImg(): String? {
        return try {
            media?.get(0)?.mediaMeta?.get(0)?.url
        } catch (e: IndexOutOfBoundsException) {
            null
        }
    }

    /**
     *  return full image of news 140x210
     * fallback will return thumbnail else null
     *
     * **/
    fun fullImg(): String? {
        return try {
            media?.get(0)?.mediaMeta?.get(2)?.url
        } catch (e: IndexOutOfBoundsException) {
            try {
                media?.get(0)?.mediaMeta?.get(0)?.url
            } catch (e: IndexOutOfBoundsException) {
                null
            }
        }
    }
}