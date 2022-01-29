package com.santimattius.template.data.models

import com.santimattius.template.domain.entities.Picture


data class PictureEntity(
    override val id: String = "",
    override val author: String = "",
    override val width: Int = 0,
    override val downloadUrl: String = "",
    override val url: String = "",
    override val height: Int = 0,
) : Picture