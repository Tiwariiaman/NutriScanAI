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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amati.nutriscanai.data.model.RiskLevel
import com.amati.nutriscanai.domain.usecase.AnalyzeHealthUseCase
import com.amati.nutriscanai.domain.usecase.ParseNutritionUseCase

@Composable
fun ResultScreen(
    extractedText: String
) {
    val nutrition = remember {
        ParseNutritionUseCase().execute(extractedText)
    }

    val healthResult = remember {
        AnalyzeHealthUseCase().execute(nutrition)
    }

    val color = when (healthResult.riskLevel) {
        RiskLevel.SAFE -> Color(0xFF2ECC71)
        RiskLevel.MODERATE -> Color(0xFFF1C40F)
        RiskLevel.DANGEROUS -> Color(0xFFE74C3C)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Health Score",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "${healthResult.scorePercentage}%",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Health Impact",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        healthResult.impactPoints.forEach {
            Text("• $it")
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}