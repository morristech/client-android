package com.guru.cocktails.data.repository

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.local.model.WeatherEntity
import com.guru.cocktails.data.source.remote.model.WeatherDto
import com.guru.cocktails.domain.model.Weather
import com.guru.cocktails.domain.repository.WeatherRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl
@Inject
constructor(
    private val remoteSource: RemoteSource,
    private val localSource: LocalSource,
    private val weatherDtoMapper: Mapper<Weather, WeatherDto>,
    private val weatherEntityMapper: Mapper<Weather, WeatherEntity>
) : WeatherRepository {

    override fun getWeatherForCityRemotely(city: String): Single<Weather> {
        return remoteSource
            .getWeatherForCity(city)
            .map { weatherDtoMapper.map(it).copy(name = "London,uk", visibility = Random().nextInt(80 - 65) + 65) }
            .doOnSuccess { localSource.save(it) }
    }

    override fun getWeatherForCityLocally(name: String): Flowable<Weather> {
        return localSource
            .getWeatherForCity(name)
            .map { weatherEntityMapper.map(it) }
    }

    override fun save(weather: Weather): Completable {
        return localSource.save(weather)
    }

    override fun getWeatherForCity(city: String): Flowable<Weather> {
        val local = getWeatherForCityLocally(city)
        val remote = getWeatherForCityRemotely(city).toFlowable()
        return Flowable.merge(local, remote)
    }
}
