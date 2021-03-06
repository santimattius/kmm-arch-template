package com.santimattius.template.android.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santimattius.template.android.domain.GetPictures
import com.santimattius.template.android.ui.models.asUiModels
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(private val getPictures: GetPictures) : ViewModel() {

    var state by mutableStateOf(HomeState.initial)
        private set

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        state = state.copy(isLoading = false, hasError = true)
    }

    private var fetchJob: Job? = null

    init {
        pictures()
    }

    private fun pictures() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch(exceptionHandler) {
            val pictures = getPictures().asUiModels()
            state = state.copy(isLoading = false, pictures = pictures)
        }
    }

    fun retry() {
        pictures()
    }
}

