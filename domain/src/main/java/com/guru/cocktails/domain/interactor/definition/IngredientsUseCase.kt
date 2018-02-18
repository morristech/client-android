package com.guru.cocktails.domain.interactor.definition

import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.model.ListBundle
import io.reactivex.Flowable

interface IngredientsUseCase {

    fun getNonAlcoList(): Flowable<ListBundle<IngredientThumb>>
}