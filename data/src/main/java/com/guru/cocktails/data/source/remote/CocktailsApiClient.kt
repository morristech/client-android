package com.guru.cocktails.data.source.remote

import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientThumbDto
import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.model.ReqBody
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CocktailsApiClient {

    @POST("alcoIngredientList")
    fun getAllAlcoholicIngredients(@Body body: ReqBody): Single<ListBundle<IngredientThumbDto>>

    @POST("nonAlcoIngredientList")
    fun getAllNonAlcoholicIngredients(@Body body: ReqBody): Single<ListBundle<IngredientThumbDto>>

    @GET("alcoIngredientDetail")
    fun getIngredientDetail(@Query("id") id: Int): Single<IngredientDetailDto>
}
