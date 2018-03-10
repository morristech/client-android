package com.guru.cocktails.data.source.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = TABLE_INGREDIENT)
data class IngredientDetailEntity(
    @PrimaryKey()
    val id: Int,
    val name: String,
    val nameGrouped: String,
    val description: String,
    val imageName: String,
    val numShowed: Int,
    val ingredientTypeId: Int,
    val ingredientTypeName: String,
    val voltage: Double
)

const val TABLE_INGREDIENT = "ingredient"

