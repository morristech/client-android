package com.guru.cocktails.domain.repository

import com.guru.cocktails.domain.model.Weather
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface WeatherRepository {
    fun getWeatherForCity(city: String): Flowable<Weather>
    fun getWeatherForCityRemotely(city: String): Single<Weather>
    fun getWeatherForCityLocally(name: String): Flowable<Weather>
    fun save(weather: Weather): Completable
}
