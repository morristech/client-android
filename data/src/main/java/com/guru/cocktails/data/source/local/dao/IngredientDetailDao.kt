package com.guru.cocktails.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.guru.cocktails.data.source.local.model.IngredientDetailEntity
import com.guru.cocktails.data.source.local.model.TABLE_INGREDIENT
import io.reactivex.Flowable

@Dao
interface IngredientDetailDao : BaseDao<IngredientDetailEntity> {

    @Query("SELECT * FROM $TABLE_INGREDIENT where id = :id")
    fun getById(id: Int): Flowable<IngredientDetailEntity>

}