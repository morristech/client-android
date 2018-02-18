package com.guru.cocktails.domain.repository

import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import io.reactivex.Flowable
import io.reactivex.Single

interface IngredientsRepository {

    fun getNonAlcoList(): Flowable<ListBundle<IngredientThumb>>

    fun getIngredientDetailForRemote(ingredientId:Int): Single<IngredientDetail>
}
