package com.amati.nutriscanai.domain.usecase

import com.amati.nutriscanai.data.model.HealthResult
import com.amati.nutriscanai.data.model.NutritionInfo
import com.amati.nutriscanai.data.model.RiskLevel
import kotlin.math.max
import kotlin.math.min

class AnalyzeHealthUseCase {

    fun execute(nutrition: NutritionInfo): HealthResult {

        var score = 100
        val impacts = mutableListOf<String>()

        nutrition.sugarG?.let {
            if (it > 15) {
                score -= 30
                impacts.add("High sugar may cause insulin spikes and weight gain")
            } else if (it > 5) {
                score -= 15
                impacts.add("Moderate sugar intake – consume in limited quantity")
            }
        }

        nutrition.fatG?.let {
            if (it > 15) {
                score -= 20
                impacts.add("High fat content may increase cholesterol levels")
            }
        }

        nutrition.sodiumMg?.let {
            if (it > 500) {
                score -= 25
                impacts.add("Excess sodium can increase blood pressure risk")
            }
        }

        nutrition.energyKcal?.let {
            if (it > 300) {
                score -= 10
                impacts.add("High calorie intake may contribute to weight gain")
            }
        }

        score = min(100, max(0, score))

        val risk = when {
            score >= 70 -> RiskLevel.SAFE
            score >= 40 -> RiskLevel.MODERATE
            else -> RiskLevel.DANGEROUS
        }

        return HealthResult(
            scorePercentage = score,
            riskLevel = risk,
            impactPoints = impacts
        )
    }
}