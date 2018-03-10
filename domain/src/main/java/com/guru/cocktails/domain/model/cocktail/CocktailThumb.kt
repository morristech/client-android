package com.guru.cocktails.domain.model.cocktail

import com.guru.cocktails.domain.model.base.BaseListItem

data class CocktailThumb(
    val id: Int,
    override val name: String,
    val image: String,
    override val imageUrl: String,
    val calculatedRating: Double,
    val alcoVolume: Double,
    val numOfFavorite: Int
) : BaseListItem(name, imageUrl)