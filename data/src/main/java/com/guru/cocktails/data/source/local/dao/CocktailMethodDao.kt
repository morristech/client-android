package com.guru.cocktails.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.guru.cocktails.data.source.local.model.CocktailMethodEntity
import com.guru.cocktails.data.source.local.model.TABLE_COCKTAIL_METHOD
import io.reactivex.Flowable

@Dao
interface CocktailMethodDao : BaseDao<CocktailMethodEntity> {

    @Query("SELECT * FROM $TABLE_COCKTAIL_METHOD where id = :id")
    fun getById(id: Int): Flowable<CocktailMethodEntity>

    @Query("SELECT * FROM $TABLE_COCKTAIL_METHOD")
    fun getAll(): Flowable<CocktailMethodEntity>

}