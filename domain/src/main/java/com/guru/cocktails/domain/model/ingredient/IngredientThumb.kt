package com.guru.cocktails.domain.model.ingredient

data class IngredientThumb(
    val id: Int,
    val imageName: String,
    val imageUrl: String,
    val name: String,
    val voltage: Double
)

enum class Type { ALCO, NON_ALCO }
