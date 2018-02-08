package com.guru.cocktails.domain.interactor

import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.interactor.definition.GetWeatherUseCase
import com.guru.cocktails.domain.model.Weather
import com.guru.cocktails.domain.repository.WeatherRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetWeatherUseCaseImpl
@Inject
constructor(
    private val schedulerProvider: SchedulerProvider,
    private val repository: WeatherRepository
) : GetWeatherUseCase {

    private fun buildUseCase(city: String): Flowable<Weather> {
        return when (city.isEmpty()) {
            true  -> Flowable.error(IllegalArgumentException("Wrong parameters"))
            false -> repository.getWeatherForCity(city)
        }
    }

    override fun execute(city: String): Flowable<Weather> {
        return buildUseCase(city).subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
    }
}