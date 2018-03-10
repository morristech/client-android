package com.guru.cocktails.data.source.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = TABLE_MY_INGREDIENT)
data class MyIngredientEntity(
    @PrimaryKey()
    val ingredientId: Int,
    val name: String,
    val imageName: String,
    val voltage: Double,
    val myBar: Boolean,
    val shoppingCart: Boolean
)

const val TABLE_MY_INGREDIENT = "ingredient_bar"

