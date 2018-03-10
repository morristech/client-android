package com.guru.cocktails.data.source.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class CocktailThumbEntity(
    @PrimaryKey()
    val id: Int,
    val name: String,
    val image: String,
    val calculatedRating: Double,
    val alcoVolume: Double,
    val numOfFavorite: Int
)

const val TABLE_COCKTAIL_THUMB = "CocktailThumbEntity"

