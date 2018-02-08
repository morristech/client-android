package com.guru.cocktails.data.source.local


import com.guru.cocktails.data.mapper.WeatherEntityMapper
import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.local.model.WeatherEntity
import com.guru.cocktails.domain.model.Weather
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherLocalSource
@Inject
constructor(
    private val db: WeatherDatabase,
    private val mapper: WeatherEntityMapper
) : LocalSource {

    override fun save(weather: Weather): Completable {
        val item = mapper.reverse(weather)

        return Completable.fromCallable {
            db.weatherDao().deleteWeatherById(item.uid)
            db.weatherDao().insert(item)
        }
    }

    override fun getWeatherForCity(name: String): Flowable<WeatherEntity> {
        return db.weatherDao().getByName(name)
    }
}
