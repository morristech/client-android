package com.guru.cocktails.data.source

import com.guru.cocktails.data.source.remote.model.WeatherDto
import com.guru.cocktails.data.source.remote.model.ingredientDto.IngredientDetailDto
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import io.reactivex.Single

interface RemoteSource {
    fun getWeatherForCity(city: String): Single<WeatherDto>

    fun getNonAlcoList(): Single<ListBundle<IngredientThumb>>

    fun getIngredientDetailForRemote(ingredientId:Int): Single<IngredientDetailDto>
}
