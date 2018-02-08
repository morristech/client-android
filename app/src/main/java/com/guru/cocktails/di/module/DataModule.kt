package com.guru.cocktails.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.guru.cocktails.data.mapper.WeatherEntityMapper
import com.guru.cocktails.data.repository.IngredientsRepositoryImpl
import com.guru.cocktails.data.repository.WeatherRepositoryImpl
import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.local.WeatherDatabase
import com.guru.cocktails.data.source.local.WeatherLocalSource
import com.guru.cocktails.data.source.remote.WeatherRemoteSource
import com.guru.cocktails.domain.repository.IngredientsRepository
import com.guru.cocktails.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    internal fun weatherRepository(repositoryImpl: WeatherRepositoryImpl): WeatherRepository {
        return repositoryImpl
    }

    @Singleton
    @Provides
    internal fun ingredientsRepository(repositoryImpl: IngredientsRepositoryImpl): IngredientsRepository {
        return repositoryImpl
    }

    @Provides
    @Singleton
    internal fun provideRemoteSource(retrofit: Retrofit): RemoteSource {
        return WeatherRemoteSource(retrofit)
    }

    @Provides
    @Singleton
    internal fun provideLocalSource(db: WeatherDatabase, mapper: WeatherEntityMapper): LocalSource {
        return WeatherLocalSource(db, mapper)
    }

    @Provides
    @Singleton
    internal fun provideRoomDb(context: Context): WeatherDatabase {
        return Room.databaseBuilder(context, WeatherDatabase::class.java, "weather-db").build()
    }
}
