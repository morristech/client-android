package com.guru.cocktails.domain.interactor.definition

import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import io.reactivex.Flowable

interface IngredientsUseCase {

    fun getAllAlcoholicIngredients(): Flowable<List<IngredientThumb>>

    fun getAllNonAlcoholicIngredients(): Flowable<List<IngredientThumb>>

    fun getIngredientDetail(ingredientId: Int): Flowable<IngredientDetail>
}