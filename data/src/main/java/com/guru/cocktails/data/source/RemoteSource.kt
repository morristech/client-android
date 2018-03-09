package com.guru.cocktails.data.source

import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailBundleDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientThumbDto
import com.guru.cocktails.domain.model.ListBundle
import io.reactivex.Single

interface RemoteSource {

    fun getAlcoIngredientList(): Single<ListBundle<IngredientThumbDto>>

    fun getNonAlcoIngredientList(): Single<ListBundle<IngredientThumbDto>>

    fun getIngredientDetail(ingredientId: Int): Single<IngredientDetailBundleDto>
}