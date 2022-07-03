package com.raoarsalan.framework.database.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.raoarsalan.core.domain.model.response.MediaModel
import com.raoarsalan.framework.database.converters.MediaModelConverter

@Entity(tableName = "popularNews")
data class NewsEntity(
    @PrimaryKey
    var id: Long,
    var source: String,
    var published_date: String,
    var byline: String,
    var type: String,
    var title: String,
    var abstractNews: String,
    @TypeConverters(MediaModelConverter::class)
    var media: List<MediaModel>?
) {
    constructor() : this(
        0,
        "",
        "",
        "",
        "",
        "",
        "",
        null
    )
}