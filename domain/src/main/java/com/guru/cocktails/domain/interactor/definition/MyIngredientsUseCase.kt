package com.guru.cocktails.domain.interactor.definition

import com.guru.cocktails.domain.model.ingredient.MyIngredient
import io.reactivex.Completable
import io.reactivex.Flowable

interface MyIngredientsUseCase {

    fun getMyIngredients(): Flowable<List<MyIngredient>>

    fun getMyIngredientById(id: Int): Flowable<MyIngredient>

    fun addToMyBar(item: MyIngredient): Completable

    fun removeFromMyBar(item: MyIngredient): Completable

    fun addToShoppingList(item: MyIngredient): Completable

    fun removeFromShoppingList(item: MyIngredient): Completable
}