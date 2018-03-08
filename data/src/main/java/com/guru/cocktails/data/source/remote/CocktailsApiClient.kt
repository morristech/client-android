package com.guru.cocktails.data.source.remote

import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientThumbDto
import com.guru.cocktails.domain.model.ListBundle
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsApiClient {

    @GET("/ingredient/list")
    fun getIngredientList(
        @Query("pageNumber") pageNumber: Int,
        @Query("pageSize") pageSize: Int
    ): Single<ListBundle<IngredientThumbDto>>

    @GET("/ingredient/detail")
    fun getIngredientDetail(@Query("id") id: Int): Single<IngredientDetailDto>
}
