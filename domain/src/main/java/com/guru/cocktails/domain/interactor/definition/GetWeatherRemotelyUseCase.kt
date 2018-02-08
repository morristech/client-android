package com.guru.cocktails.domain.interactor.definition

import com.guru.cocktails.domain.model.Weather
import io.reactivex.Single

interface GetWeatherRemotelyUseCase {

    fun execute(city: String): Single<Weather>
}