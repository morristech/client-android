package com.guru.cocktails.data.source

import com.guru.cocktails.data.source.local.model.CocktailThumbEntity
import com.guru.cocktails.data.source.local.model.IngredientDetailEntity
import com.guru.cocktails.data.source.local.model.IngredientThumbEntity
import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import io.reactivex.Completable
import io.reactivex.Flowable

interface LocalSource {

    fun getAllAlcoholic(): Flowable<List<IngredientThumbEntity>>

    fun getAllNonAlcoholic(): Flowable<List<IngredientThumbEntity>>

    fun saveIngredientsThumb(item: List<IngredientThumb>): Completable

    fun getIngredientDetail(id: Int): Flowable<IngredientDetailEntity>

    fun saveIngredientDetail(item: IngredientDetail): Completable

    fun getCocktailsList(): Flowable<List<CocktailThumbEntity>>

    fun saveCocktailsList(list: List<CocktailThumb>): Completable
}
