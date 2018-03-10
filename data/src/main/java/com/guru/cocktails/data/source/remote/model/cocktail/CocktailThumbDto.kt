package com.guru.cocktails.data.source.remote.model.cocktail

data class CocktailThumbDto(
    val id: Int?,
    val name: String?,
    val image: String?,
    val calculatedRating: Double?,
    val alcoVolume: Double?,
    val numOfFavorite: Int?
)