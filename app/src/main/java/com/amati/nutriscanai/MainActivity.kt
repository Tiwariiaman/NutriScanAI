package com.amati.nutriscanai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.amati.nutriscanai.data.ocr.TextRecognizerHelper
import com.amati.nutriscanai.ui.camera.CameraScreen
import com.amati.nutriscanai.ui.camera.CameraViewModel
import com.amati.nutriscanai.ui.home.HomeScreen
import com.amati.nutriscanai.ui.result.ResultScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            MaterialTheme {
                val cameraViewModel = remember { CameraViewModel() }
                var extractedText by remember { mutableStateOf("") }
                var screen by remember { mutableStateOf("home") }
//                var showCamera by remember { mutableStateOf(false) }

                when (screen) {
                    "home" -> HomeScreen {
                        screen = "camera"
                    }

                    "camera" -> CameraScreen(
                        viewModel = cameraViewModel,
                        onImageCaptured = {
                            val bitmap = cameraViewModel.uiState.value.capturedBitmap
                            bitmap?.let {
                                TextRecognizerHelper().recognizeText(
                                    bitmap = it,
                                    onResult = { text ->
                                        extractedText = text
                                        screen = "result"
                                    },
                                    onError = { it.printStackTrace() }
                                )
                            }
                        }
                    )

                    "result" -> ResultScreen(extractedText)
                }
            }
        }
    }
}

