package com.raoarsalan.core.domain.model.response

import com.google.gson.annotations.SerializedName

data class MediaModel(
    val type: String,
    @SerializedName("media-metadata")
    val mediaMeta: List<MediaMetaDataModel>?
)