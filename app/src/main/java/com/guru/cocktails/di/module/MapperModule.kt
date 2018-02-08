package com.guru.cocktails.di.module

import com.guru.cocktails.data.mapper.WeatherEntityMapper
import com.guru.cocktails.data.mapper.WeatherMapper
import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.local.model.WeatherEntity
import com.guru.cocktails.data.source.remote.model.WeatherDto
import com.guru.cocktails.domain.model.Weather
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {

    @Singleton
    @Provides
    internal fun weatherMapper(mapper: WeatherMapper): Mapper<Weather, WeatherDto> {
        return mapper
    }

    @Singleton
    @Provides
    internal fun weatherEntityMapper(mapper: WeatherEntityMapper): Mapper<Weather, WeatherEntity> {
        return mapper
    }

}
