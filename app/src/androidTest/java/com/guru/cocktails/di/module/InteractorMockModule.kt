package com.guru.cocktails.di.module

import com.guru.cocktails.domain.interactor.definition.GetWeatherLocallyUseCase
import com.guru.cocktails.domain.interactor.definition.GetWeatherRemotelyUseCase
import com.guru.cocktails.domain.interactor.definition.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import org.mockito.Mockito
import javax.inject.Singleton

@Module
class InteractorMockModule {

    @Singleton
    @Provides
    internal fun getWeatherRemotelyUseCase(): GetWeatherRemotelyUseCase {
        return Mockito.mock(GetWeatherRemotelyUseCase::class.java)
    }

    @Singleton
    @Provides
    internal fun getWeatherLocallyUseCase(): GetWeatherLocallyUseCase {
        return Mockito.mock(GetWeatherLocallyUseCase::class.java)
    }

    @Singleton
    @Provides
    internal fun getWeatherUseCase(): GetWeatherUseCase {
        return Mockito.mock(GetWeatherUseCase::class.java)
    }
}