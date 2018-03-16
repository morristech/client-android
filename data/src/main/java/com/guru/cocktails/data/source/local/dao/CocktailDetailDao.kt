package com.guru.cocktails.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.guru.cocktails.data.source.local.model.CocktailDetailEntity
import com.guru.cocktails.data.source.local.model.TABLE_COCKTAIL
import io.reactivex.Flowable

@Dao
interface CocktailDetailDao : BaseDao<CocktailDetailEntity> {

    @Query("SELECT * FROM $TABLE_COCKTAIL where id = :id")
    fun getById(id: Int): Flowable<CocktailDetailEntity>
}