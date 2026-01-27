package com.amati.nutriscanai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.amati.nutriscanai.ui.camera.CameraScreen
import com.amati.nutriscanai.ui.camera.CameraViewModel
import com.amati.nutriscanai.ui.home.HomeScreen
import com.amati.nutriscanai.ui.theme.NutriScanAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {

                var showCamera by remember { mutableStateOf(false) }

                if (showCamera) {
                    CameraScreen(
                        viewModel = CameraViewModel(),
                        onImageCaptured = {
                            // Next step: OCR
                        }
                    )
                } else {
                    HomeScreen(
                        onScanClick = {
                            showCamera = true
                        }
                    )
                }
            }
        }
    }
}

