package com.santimattius.template.android.ui.viewmodels

import com.santimattius.template.android.ui.models.PictureUiModel

data class HomeState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val pictures: List<PictureUiModel> = emptyList(),
) {
    companion object {

        val initial = HomeState(isLoading = true)
    }
}

val HomeState.isEmpty: Boolean get() = pictures.isEmpty()