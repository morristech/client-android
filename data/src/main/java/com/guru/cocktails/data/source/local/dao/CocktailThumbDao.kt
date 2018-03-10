package com.guru.cocktails.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.guru.cocktails.data.source.local.model.CocktailThumbEntity
import com.guru.cocktails.data.source.local.model.TABLE_COCKTAIL_THUMB
import io.reactivex.Flowable

@Dao
interface CocktailThumbDao : BaseDao<CocktailThumbEntity> {

    @Query("SELECT * FROM $TABLE_COCKTAIL_THUMB")
    fun getAllCocktails(): Flowable<List<CocktailThumbEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(list: List<CocktailThumbEntity>)
}