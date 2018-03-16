package com.guru.cocktails.data.source.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = TABLE_COCKTAIL)
data class CocktailDetailEntity(
    @PrimaryKey()
    val id: Long,
    val name: String,
    val totalVolume: Int,
    val alcoVolume: Int,
    val nonAlcoVolume: Int,
    val instructions: String,
    val garnish: String,
    val description: String,
    val imageName: String,
    val glassId: Int,
    val methodId: Int,
    val ingredientList: String,
    val similarCocktailList: String,
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

const val TABLE_COCKTAIL = "cocktail"

