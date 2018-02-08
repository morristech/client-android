package com.guru.cocktails.data.repository

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.local.model.WeatherEntity
import com.guru.cocktails.data.source.remote.model.WeatherDto
import com.guru.cocktails.domain.model.IngredientThumb
import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.model.Weather
import com.guru.cocktails.domain.repository.IngredientsRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientsRepositoryImpl
@Inject
constructor(
    private val remoteSource: RemoteSource,
    private val localSource: LocalSource,
    private val weatherDtoMapper: Mapper<Weather, WeatherDto>,
    private val weatherEntityMapper: Mapper<Weather, WeatherEntity>
) : IngredientsRepository {

    override fun getNonAlcoList(): Flowable<ListBundle<IngredientThumb>> {
        return remoteSource.getNonAlcoList().toFlowable()
    }
}
