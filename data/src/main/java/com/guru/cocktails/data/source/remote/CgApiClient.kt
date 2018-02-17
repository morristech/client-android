package com.guru.cocktails.data.source.remote

import com.guru.cocktails.data.source.remote.model.WeatherDto
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.model.ReqBody
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface CgApiClient {
    @GET("data/2.5/weather")
    fun getWeatherForCity(@Query("q") city: String): Single<WeatherDto>

    @POST("alcoIngredientList")
    fun getNonAlcoList(@Body body: ReqBody): Single<ListBundle<IngredientThumb>>
}
