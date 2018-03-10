package com.guru.cocktails.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.guru.cocktails.data.source.local.dao.CocktailThumbDao
import com.guru.cocktails.data.source.local.dao.IngredientDetailDao
import com.guru.cocktails.data.source.local.dao.IngredientThumbDao
import com.guru.cocktails.data.source.local.model.CocktailThumbEntity
import com.guru.cocktails.data.source.local.model.IngredientDetailEntity
import com.guru.cocktails.data.source.local.model.IngredientThumbEntity

@Database(
    entities = [
        (IngredientThumbEntity::class),
        (IngredientDetailEntity::class),
        (CocktailThumbEntity::class)
    ], version = 1
)
abstract class CocktailsDatabase : RoomDatabase() {
    abstract fun ingredientThumbDao(): IngredientThumbDao
    abstract fun ingredientDetailDao(): IngredientDetailDao
    abstract fun cocktailThumbDao(): CocktailThumbDao
}