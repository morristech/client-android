package com.guru.cocktails.domain.model.ingredient

import com.guru.cocktails.domain.model.base.BaseListItem

data class IngredientThumb(
    val id: Int,
    override val name: String,
    val imageName: String,
    override val imageUrl: String,
    val voltage: Double
) : BaseListItem(name, imageUrl)

