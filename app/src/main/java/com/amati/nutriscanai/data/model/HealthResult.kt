package com.amati.nutriscanai.data.model

enum class RiskLevel {
    SAFE, MODERATE, DANGEROUS
}

data class HealthResult(
    val scorePercentage: Int,
    val riskLevel: RiskLevel,
    val impactPoints: List<String>
)