package com.guru.cocktails.di.module

import com.guru.cocktails.data.mapper.IngredientTypeMapper
import com.guru.cocktails.data.mapper.IngredientDetailMapper
import com.guru.cocktails.data.mapper.WeatherEntityMapper
import com.guru.cocktails.data.mapper.WeatherMapper
import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.local.model.WeatherEntity
import com.guru.cocktails.data.source.remote.model.WeatherDto
import com.guru.cocktails.data.source.remote.model.ingredientDto.IngredientDetailDto
import com.guru.cocktails.data.source.remote.model.ingredientDto.IngredientTypeDto
import com.guru.cocktails.domain.model.Weather
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientType
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

    @Singleton
    @Provides
    internal fun ingredientDetailMapper(mapper: IngredientDetailMapper): Mapper<IngredientDetail, IngredientDetailDto> {
        return mapper
    }

    @Singleton
    @Provides
    internal fun ingredientTypeMapper(mapper: IngredientTypeMapper): Mapper<IngredientType, IngredientTypeDto> {
        return mapper
    }
}