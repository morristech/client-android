package com.guru.cocktails.data.source.remote.model.ingredientDto

data class IngredientDetailDto (
        val id: Int?,
        val name: String?,
        val nameGrouped: String?,
        val description: String?,
        val imageName: String?,
        val numShowed: Int?,
        val ingredientType: IngredientTypeDto?,
        val voltage: Int?
)