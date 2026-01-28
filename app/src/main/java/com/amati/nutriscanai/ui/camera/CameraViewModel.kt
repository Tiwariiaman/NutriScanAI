package com.amati.nutriscanai.ui.camera

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CameraViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CameraUiState())
    val uiState = _uiState.asStateFlow()

    fun onImageCaptured(bitmap: Bitmap) {
        _uiState.value = CameraUiState(capturedBitmap = bitmap)
    }

}

data class  CameraUiState(
    val capturedBitmap: Bitmap? = null

)