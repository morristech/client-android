package com.guru.cocktails.data.source.remote.model.ingredient

data class IngredientTypeDto(
    val id: Int?,
    val name: String?
) {
    companion object {
        val EMPTY = IngredientTypeDto(-1, "")
    }
}