package com.amati.nutriscanai.domain.usecase

import com.amati.nutriscanai.data.model.NutritionInfo

class ParseNutritionUseCase {

    fun execute(text: String): NutritionInfo {
        return NutritionInfo(
            energyKcal = extractInt(text, "(energy|calories).*?(\\d+)\\s*k?cal"),
            sugarG = extractInt(text, "(sugar|added sugar).*?(\\d+)\\s*g"),
            fatG = extractInt(text, "(fat|total fat).*?(\\d+)\\s*g"),
            proteinG = extractInt(text, "(protein).*?(\\d+)\\s*g"),
            sodiumMg = extractInt(text, "(sodium|salt).*?(\\d+)\\s*mg")
        )
    }

    private fun extractInt(text: String, pattern: String): Int? {
        val regex = Regex(pattern, RegexOption.IGNORE_CASE)
        return regex.find(text)?.groupValues?.get(2)?.toIntOrNull()
    }
}