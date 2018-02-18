package com.guru.cocktails.domain.repository

import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import io.reactivex.Flowable

interface IngredientsRepository {

    fun getAllAlcoholicIngredients(): Flowable<List<IngredientThumb>>

    fun getAllNonAlcoholicIngredients(): Flowable<List<IngredientThumb>>

    fun getIngredientDetail(ingredientId: Int): Flowable<IngredientDetail>
}
