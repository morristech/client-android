package com.guru.cocktails.domain.model.mapper

import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.MyIngredient
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class MyIngredientMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String
) {
    fun map(from: IngredientDetail) = with(from) {
        MyIngredient(
            ingredientId = id,
            name = name,
            imageUrl = "${baseUrl}assets/ingred/thumb_300/$imageName",
            imageName = imageName,
            voltage = voltage,
            shoppingCart = false,
            myBar = false
        )
    }
}