package com.guru.cocktails.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.guru.cocktails.data.source.local.model.MyIngredientEntity
import com.guru.cocktails.data.source.local.model.TABLE_MY_INGREDIENT
import io.reactivex.Flowable

@Dao
interface MyIngredientDao : BaseDao<MyIngredientEntity> {

    @Query("SELECT * FROM $TABLE_MY_INGREDIENT where myBar=1")
    fun getMyIngredients(): Flowable<List<MyIngredientEntity>>

    @Query("SELECT * FROM $TABLE_MY_INGREDIENT where shoppingCart=1")
    fun getShoppingList(): Flowable<List<MyIngredientEntity>>

    @Query("SELECT * FROM $TABLE_MY_INGREDIENT where ingredientId = :ingredientId")
    fun getMyIngredientById(ingredientId: Int): Flowable<MyIngredientEntity>
}