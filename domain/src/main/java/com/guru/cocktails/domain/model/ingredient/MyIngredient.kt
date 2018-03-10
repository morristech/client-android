package com.guru.cocktails.domain.model.ingredient

/**
 * Used to display list of ingredients that user has in his/her bar or shopping list.
 */
data class MyIngredient(
    val ingredientId: Int,
    val name: String,
    val imageName: String,
    val imageUrl: String,
    val voltage: Double,
    val myBar: Boolean,
    val shoppingCart: Boolean
)

