package com.guru.cocktails.data.source.remote.model.cocktail


data class CocktailDetailDto(
    val id: Long,
    val name: String,
    val totalVolume: Int,
    val alcoVolume: Int,
    val nonAlcoVolume: Int,
    val instructions: String,
    val garnish: String,
    val description: String,
    val imageName: String,
    val glass: CocktailGlassDto,
    val method: CocktailMethodDto,
    val ingredientList: List<Long>,
    val similarCocktailList: List<Long>,
    val numOfFavorite: Long,
    val calculatedRating: Double,
    val numRating1: Int,
    val numRating2: Int,
    val numRating3: Int,
    val numRating4: Int,
    val numRating5: Int,
    val alcoholVolume: Double,
    val numPictures: Int,
    val numComments: Int,
    val numShowed: Int
)