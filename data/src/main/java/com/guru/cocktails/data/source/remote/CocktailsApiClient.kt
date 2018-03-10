package com.guru.cocktails.data.source.remote

import com.guru.cocktails.data.source.remote.model.cocktail.CocktailThumbDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailBundleDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientThumbDto
import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.model.ingredient.Type
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsApiClient {

    @GET("/cocktail/list")
    fun getCocktailsList(
        @Query("pageNumber") pageNumber: Int,
        @Query("pageSize") pageSize: Int
    ): Single<ListBundle<CocktailThumbDto>>

    @GET("/ingredient/list")
    fun getIngredientList(
        @Query("pageNumber") pageNumber: Int,
        @Query("pageSize") pageSize: Int,
        @Query("ingredientType") ingredientType: Type
    ): Single<ListBundle<IngredientThumbDto>>

    @GET("/ingredient/detail")
    fun getIngredientDetail(@Query("id") id: Int): Single<IngredientDetailBundleDto>
}
