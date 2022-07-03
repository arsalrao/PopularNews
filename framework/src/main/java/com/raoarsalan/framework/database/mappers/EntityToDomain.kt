package com.raoarsalan.framework.database.mappers

import com.raoarsalan.core.domain.model.response.NewsModel
import com.raoarsalan.framework.database.entitiy.NewsEntity

internal fun NewsEntity.toDomain() = NewsModel(
    id = id,
    source = source,
    published_date = published_date,
    byline = byline,
    type = type,
    title = title,
    abstract = abstract,
    media = media
)

internal fun List<NewsEntity>.toDomain(): List<NewsModel> {
    return this.map { it.toDomain() }
}

