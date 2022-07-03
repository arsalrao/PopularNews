package com.raoarsalan.framework.database.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.raoarsalan.core.domain.model.response.MediaModel
import com.raoarsalan.framework.database.converters.MediaModelConverter

@Entity(tableName = "popularNews")
class NewsEntity(
    @PrimaryKey
    val id: Long,
    val source: String,
    val published_date: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    @TypeConverters(MediaModelConverter::class)
    val media: List<MediaModel>?
)