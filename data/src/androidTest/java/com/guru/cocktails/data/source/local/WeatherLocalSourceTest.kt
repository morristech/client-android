package com.guru.cocktails.data.source.local

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import com.guru.cocktails.data.mapper.WeatherEntityMapper
import com.guru.cocktails.domain.model.Weather
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class WeatherLocalSourceTest {

    lateinit var dataSource: WeatherLocalSource
    lateinit var database: WeatherDatabase
    lateinit var mapper: WeatherEntityMapper

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), WeatherDatabase::class.java).build()
        mapper = WeatherEntityMapper()
        dataSource = WeatherLocalSource(database, mapper)
    }

    @After
    @Throws(Exception::class)
    fun closeDb() {
        database.close()
    }

    @Test
    fun shouldInsertAndGetWeather() {

        val weather = Weather(30L, "Berlin", 123)
        dataSource.save(weather)

        val weatherEntity = dataSource.getWeatherForCity(weather.name).blockingFirst()
        Assert.assertEquals(weatherEntity.uid, weather.id)
        Assert.assertEquals(weatherEntity.name, weather.name)
        Assert.assertEquals(weatherEntity.visibility, weather.visibility)
    }
}