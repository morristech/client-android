package com.guru.cocktails.domain.model.ingredient

data class IngredientDetail(
        val id: Int,
        val name: String,
        val nameGrouped: String,
        val description: String,
        val imageName: String,
        val numShowed: Int,
        val ingredientType: IngredientType,
        val voltage: Int
)