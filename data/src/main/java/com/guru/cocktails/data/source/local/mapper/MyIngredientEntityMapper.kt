package com.guru.cocktails.data.source.local.mapper

import com.guru.cocktails.data.source.local.model.MyIngredientEntity
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.ingredient.MyIngredient
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class MyIngredientEntityMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String
) : Mapper<MyIngredient, MyIngredientEntity>() {

    override fun map(from: MyIngredientEntity) = with(from) {
        MyIngredient(
            ingredientId = ingredientId,
            name = name,
            imageUrl = "${baseUrl}assets/ingred/thumb_300/$imageName",
            imageName = imageName,
            voltage = voltage,
            shoppingCart = shoppingCart,
            myBar = myBar
        )
    }

    override fun reverse(to: MyIngredient) = with(to) {
        MyIngredientEntity(
            ingredientId = ingredientId,
            imageName = imageName,
            name = name,
            voltage = voltage,
            myBar = myBar,
            shoppingCart = shoppingCart
        )
    }
}