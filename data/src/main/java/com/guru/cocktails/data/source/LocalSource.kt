package com.guru.cocktails.data.source

import com.guru.cocktails.data.source.local.model.IngredientThumbEntity
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import io.reactivex.Completable
import io.reactivex.Flowable

interface LocalSource {

    fun getAllAlcoholic(): Flowable<List<IngredientThumbEntity>>

    fun getAllNonAlcoholic(): Flowable<List<IngredientThumbEntity>>

    fun saveIngredientsThumb(weather: List<IngredientThumb>): Completable
}
