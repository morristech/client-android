package com.guru.cocktails.domain.interactor.definition

import com.guru.cocktails.domain.model.Weather
import io.reactivex.Flowable

interface GetWeatherUseCase {

    fun execute(city: String): Flowable<Weather>
}