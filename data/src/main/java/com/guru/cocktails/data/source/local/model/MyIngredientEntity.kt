package com.guru.cocktails.data.source.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = TABLE_MY_INGREDIENT)
data class MyIngredientEntity(
    @PrimaryKey()
    val id: Int,
    val imageName: String,
    val myBar: Boolean,
    val shoppingCart: Boolean
)

const val TABLE_MY_INGREDIENT = "my_ingredients"

