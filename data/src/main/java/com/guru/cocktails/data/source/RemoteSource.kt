package com.guru.cocktails.data.source

import com.guru.cocktails.data.source.remote.model.cocktail.CocktailDetailBundleDto
import com.guru.cocktails.data.source.remote.model.cocktail.CocktailThumbDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailBundleDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientThumbDto
import com.guru.cocktails.domain.model.ListBundle
import io.reactivex.Single

interface RemoteSource {

    fun getCocktailDetail(id: Int): Single<CocktailDetailBundleDto>

    fun getCocktailsList(): Single<ListBundle<CocktailThumbDto>>

    fun getAlcoIngredientList(): Single<ListBundle<IngredientThumbDto>>

    fun getNonAlcoIngredientList(): Single<ListBundle<IngredientThumbDto>>

    fun getIngredientDetail(id: Int): Single<IngredientDetailBundleDto>
}