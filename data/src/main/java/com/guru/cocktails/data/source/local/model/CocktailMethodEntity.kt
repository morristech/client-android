package com.guru.cocktails.data.source.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = TABLE_COCKTAIL_METHOD)
data class CocktailMethodEntity(
    @PrimaryKey()
    val id: Int,
    val name: String,
    val description: String
)

const val TABLE_COCKTAIL_METHOD = "cocktail_method"

