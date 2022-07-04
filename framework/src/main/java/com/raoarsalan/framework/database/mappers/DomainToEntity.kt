package com.raoarsalan.framework.database.mappers

import com.raoarsalan.core.domain.model.response.NewsModel
import com.raoarsalan.framework.database.entitiy.NewsEntity

internal fun NewsModel.toEntity() = NewsEntity(
    id = id,
    source = source,
    publishedDate = publishedDate,
    byline = byline,
    type = type,
    title = title,
    abstractNews = abstractNews,
    media = media
)

internal fun List<NewsModel>.toEntity(): List<NewsEntity> {
    return this.map { it.toEntity() }
}