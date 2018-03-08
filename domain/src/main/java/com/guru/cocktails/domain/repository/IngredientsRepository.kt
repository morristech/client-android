package com.guru.cocktails.domain.repository

import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import io.reactivex.Completable
import io.reactivex.Flowable

interface IngredientsRepository {

    /* Alco Ingredients list*/
    fun getAllAlcoholicIngredients(): Flowable<List<IngredientThumb>>

    fun saveAllAlcoholicIngredients(list: List<IngredientThumb>): Completable

    fun refreshAllAlcoholicIngredients(): Completable

    /* Non Alco Ingredients list*/
    fun getAllNonAlcoholicIngredients(): Flowable<List<IngredientThumb>>

    fun saveAllNonAlcoholicIngredients(list: List<IngredientThumb>): Completable

    fun refreshAllNonAlcoholicIngredients(): Completable

    /* Ingredient Detail*/
    fun getIngredientDetail(ingredientId: Int): Flowable<IngredientDetail>
}
