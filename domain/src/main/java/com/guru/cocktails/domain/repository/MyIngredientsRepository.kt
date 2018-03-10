package com.guru.cocktails.domain.repository

import com.guru.cocktails.domain.model.ingredient.MyIngredient
import io.reactivex.Completable
import io.reactivex.Flowable

interface MyIngredientsRepository {

    fun getMyIngredientById(id: Int): Flowable<MyIngredient>

    fun getMyIngredients(): Flowable<List<MyIngredient>>

    fun addMyIngredient(item: MyIngredient): Completable

    fun removeMyIngredient(item: MyIngredient): Completable
}
