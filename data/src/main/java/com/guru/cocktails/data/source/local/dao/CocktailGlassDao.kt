package com.guru.cocktails.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.guru.cocktails.data.source.local.model.CocktailGlassEntity
import com.guru.cocktails.data.source.local.model.TABLE_COCKTAIL_GLASS
import io.reactivex.Flowable

@Dao
interface CocktailGlassDao : BaseDao<CocktailGlassEntity> {

    @Query("SELECT * FROM $TABLE_COCKTAIL_GLASS where id = :id")
    fun getById(id: Int): Flowable<CocktailGlassEntity>

    @Query("SELECT * FROM $TABLE_COCKTAIL_GLASS")
    fun getAll(): Flowable<CocktailGlassEntity>

}