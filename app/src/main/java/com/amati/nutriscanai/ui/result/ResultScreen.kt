package com.amati.nutriscanai.ui.result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amati.nutriscanai.domain.usecase.ParseNutritionUseCase

@Composable
fun ResultScreen(
    extractedText: String
) {
    val nutrition = remember {
        ParseNutritionUseCase().execute(extractedText)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Nutrition Summary", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Energy: ${nutrition.energyKcal ?: "--"} kcal")
        Text("Sugar: ${nutrition.sugarG ?: "--"} g")
        Text("Fat: ${nutrition.fatG ?: "--"} g")
        Text("Protein: ${nutrition.proteinG ?: "--"} g")
        Text("Sodium: ${nutrition.sodiumMg ?: "--"} mg")
    }
}