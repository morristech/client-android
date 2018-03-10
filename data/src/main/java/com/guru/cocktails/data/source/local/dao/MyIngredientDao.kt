package com.guru.cocktails.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.guru.cocktails.data.source.local.model.IngredientThumbEntity
import com.guru.cocktails.data.source.local.model.MyIngredientEntity
import com.guru.cocktails.data.source.local.model.TABLE_INGREDIENT_THUMB
import io.reactivex.Flowable

@Dao
interface MyIngredientDao : BaseDao<MyIngredientEntity> {

    @Query("SELECT * FROM $TABLE_INGREDIENT_THUMB where voltage > 0")
    fun getAllAlcoholic(): Flowable<List<IngredientThumbEntity>>

    @Query("SELECT * FROM $TABLE_INGREDIENT_THUMB where voltage == 0")
    fun getAllNonAlcoholic(): Flowable<List<IngredientThumbEntity>>

}