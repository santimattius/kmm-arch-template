package com.santimattius.template.android.ui.models

import com.santimattius.template.domain.entities.Picture


internal fun List<Picture>.asUiModels() = map { it.asUiModel() }

internal fun Picture.asUiModel() =
    PictureUiModel(
        id = id,
        author = author,
        imageUrl = downloadUrl,
        height = height,
        width = width,
        link = url
    )