package com.guru.cocktails.domain.model.ingredient

import com.guru.cocktails.domain.model.base.BaseListItem

/**
 * Used to display list of ingredients that user has in his/her bar or shopping list.
 */
data class MyIngredient(
    val ingredientId: Int,
    override val name: String,
    val imageName: String,
    override val imageUrl: String,
    val voltage: Double,
    val myBar: Boolean,
    val shoppingCart: Boolean
) : BaseListItem(name, imageUrl)

