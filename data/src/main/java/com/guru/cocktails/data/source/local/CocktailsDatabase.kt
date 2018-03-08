package com.guru.cocktails.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.guru.cocktails.data.source.local.dao.IngredientThumbDao
import com.guru.cocktails.data.source.local.model.IngredientThumbEntity


@Database(entities = arrayOf(IngredientThumbEntity::class), version = 1)
abstract class CocktailsDatabase : RoomDatabase() {
    abstract fun ingredientThumbDao(): IngredientThumbDao
}