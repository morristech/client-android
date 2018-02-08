package com.guru.cocktails.domain.interactor

import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.interactor.definition.GetWeatherRemotelyUseCase
import com.guru.cocktails.domain.model.Weather
import com.guru.cocktails.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetWeatherRemotelyUseCaseImpl
@Inject
constructor(
    private val schedulerProvider: SchedulerProvider,
    private val repository: WeatherRepository
) : GetWeatherRemotelyUseCase {

    private fun buildUseCase(city: String): Single<Weather> {
        return when (city.isEmpty()) {
            true  -> Single.error(IllegalArgumentException("Wrong parameters"))
            false -> repository.getWeatherForCityRemotely(city)
        }
    }

    override fun execute(city: String): Single<Weather> {
        return buildUseCase(city).subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
    }

}
