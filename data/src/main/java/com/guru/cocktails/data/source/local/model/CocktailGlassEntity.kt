package com.guru.cocktails.data.source.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = TABLE_COCKTAIL_GLASS)
data class CocktailGlassEntity(
    @PrimaryKey()
    val id: Int,
    val name: String
)

const val TABLE_COCKTAIL_GLASS = "cocktail_glass"

