package com.guru.cocktails.di.module

import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.interactor.GetWeatherLocallyUseCaseImpl
import com.guru.cocktails.domain.interactor.GetWeatherRemotelyUseCaseImpl
import com.guru.cocktails.domain.interactor.GetWeatherUseCaseImpl
import com.guru.cocktails.domain.interactor.IngredientsUseCaseImpl
import com.guru.cocktails.domain.interactor.definition.GetWeatherLocallyUseCase
import com.guru.cocktails.domain.interactor.definition.GetWeatherRemotelyUseCase
import com.guru.cocktails.domain.interactor.definition.GetWeatherUseCase
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.domain.repository.IngredientsRepository
import com.guru.cocktails.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class InteractorModule {

    @Singleton
    @Provides
    internal fun getWeatherRemotelyUseCase(schedulerProvider: SchedulerProvider, repository: WeatherRepository): GetWeatherRemotelyUseCase {
        return GetWeatherRemotelyUseCaseImpl(schedulerProvider, repository)
    }

    @Singleton
    @Provides
    internal fun getWeatherLocallyUseCase(schedulerProvider: SchedulerProvider, repository: WeatherRepository): GetWeatherLocallyUseCase {
        return GetWeatherLocallyUseCaseImpl(schedulerProvider, repository)
    }

    @Singleton
    @Provides
    internal fun getWeatherUseCase(schedulerProvider: SchedulerProvider, repository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCaseImpl(schedulerProvider, repository)
    }

    @Singleton
    @Provides
    internal fun getIngredientsUseCase(schedulerProvider: SchedulerProvider, repository: IngredientsRepository): IngredientsUseCase {
        return IngredientsUseCaseImpl(schedulerProvider, repository)
    }
}
