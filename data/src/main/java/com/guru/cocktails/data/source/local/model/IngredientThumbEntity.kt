package com.guru.cocktails.data.source.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class IngredientThumbEntity(
    @PrimaryKey()
    val id: Int,
    val imageName: String,
    val name: String,
    val voltage: Double
)

const val TABLE_INGREDIENT_THUMB = "IngredientThumbEntity"

