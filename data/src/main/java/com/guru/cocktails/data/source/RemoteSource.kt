package com.guru.cocktails.data.source

import com.guru.cocktails.data.source.remote.model.WeatherDto
import com.guru.cocktails.domain.model.IngredientThumb
import com.guru.cocktails.domain.model.ListBundle
import io.reactivex.Single

interface RemoteSource {
    fun getWeatherForCity(city: String): Single<WeatherDto>

    fun getNonAlcoList(): Single<ListBundle<IngredientThumb>>
}
