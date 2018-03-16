package com.guru.cocktails.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.guru.cocktails.data.source.local.dao.*
import com.guru.cocktails.data.source.local.model.*

@Database(
    entities = [
        (IngredientThumbEntity::class),
        (MyIngredientEntity::class),
        (IngredientDetailEntity::class),
        (CocktailThumbEntity::class),
        (CocktailMethodEntity::class),
        (CocktailGlassEntity::class),
        (CocktailDetailEntity::class)
    ], version = 1
)
abstract class CocktailsDatabase : RoomDatabase() {
    abstract fun myIngredientDao(): MyIngredientDao
    abstract fun ingredientThumbDao(): IngredientThumbDao
    abstract fun ingredientDetailDao(): IngredientDetailDao
    abstract fun cocktailThumbDao(): CocktailThumbDao
    abstract fun cocktailGlassDao(): CocktailGlassDao
    abstract fun cocktailMethodDao(): CocktailMethodDao
    abstract fun cocktailDetailDao(): CocktailDetailDao
    abstract fun cocktailDetailBundleDao(): CocktailDetailBundleDao
}