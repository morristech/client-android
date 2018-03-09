package com.guru.cocktails.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.guru.cocktails.data.source.local.model.IngredientThumbEntity
import com.guru.cocktails.data.source.local.model.TABLE_INGREDIENT_THUMB
import io.reactivex.Flowable

@Dao
interface IngredientThumbDao : BaseDao<IngredientThumbEntity> {

    @Query("SELECT * FROM $TABLE_INGREDIENT_THUMB where voltage > 0")
    fun getAllAlcoholic(): Flowable<List<IngredientThumbEntity>>

    @Query("SELECT * FROM $TABLE_INGREDIENT_THUMB where voltage == 0")
    fun getAllNonAlcoholic(): Flowable<List<IngredientThumbEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(list: List<IngredientThumbEntity>)
}