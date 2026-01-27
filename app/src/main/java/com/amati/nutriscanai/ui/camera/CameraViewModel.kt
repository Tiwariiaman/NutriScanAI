package com.amati.nutriscanai.ui.camera

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CameraViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CameraUiState())
    val uiState = _uiState.asStateFlow()

    fun onImageCaptured() {
        _uiState.value = _uiState.value.copy(isImageCaptured = true)
    }

}

data class  CameraUiState(
    val isImageCaptured: Boolean = false

)