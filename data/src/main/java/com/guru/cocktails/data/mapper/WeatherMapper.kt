package com.guru.cocktails.data.mapper

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.remote.model.WeatherDto
import com.guru.cocktails.domain.model.Weather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherMapper
@Inject
constructor() : Mapper<Weather, WeatherDto>() {

    override fun map(input: WeatherDto): Weather {

        val id = input.id ?: invalidLong
        val name = input.name ?: emptyString
        val visibility = input.visibility ?: invalidInt

        return Weather(id, name, visibility)
    }

    override fun reverse(input: Weather): WeatherDto {
        return WeatherDto(input.id, input.name, input.visibility)
    }
}
