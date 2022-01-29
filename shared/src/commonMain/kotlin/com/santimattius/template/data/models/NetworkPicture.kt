package com.santimattius.template.data.models

import com.santimattius.template.domain.entities.Picture
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPicture(
    @SerialName("author") override val author: String = "",
    @SerialName("width") override val width: Int = 0,
    @SerialName("download_url") override val downloadUrl: String = "",
    @SerialName("id") override val id: String = "",
    @SerialName("url") override val url: String = "",
    @SerialName("height") override val height: Int = 0,
) : Picture

@Serializable
data class Response(
    @SerialName("data") val data: List<NetworkPicture>,
)