package com.guru.cocktails.data.source

import com.guru.cocktails.data.source.local.model.WeatherEntity
import com.guru.cocktails.domain.model.Weather
import io.reactivex.Completable
import io.reactivex.Flowable

interface LocalSource {
    fun getWeatherForCity(name: String): Flowable<WeatherEntity>
    fun save(weather: Weather): Completable
}
