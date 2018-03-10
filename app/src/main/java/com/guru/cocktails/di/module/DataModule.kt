package com.guru.cocktails.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.guru.cocktails.data.repository.CocktailsRepositoryImpl
import com.guru.cocktails.data.repository.IngredientsRepositoryImpl
import com.guru.cocktails.data.repository.MyIngredientsRepositoryImpl
import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.local.CocktailsDatabase
import com.guru.cocktails.data.source.local.LocalSourceImpl
import com.guru.cocktails.data.source.remote.CocktailsRemoteSource
import com.guru.cocktails.domain.repository.CocktailsRepository
import com.guru.cocktails.domain.repository.IngredientsRepository
import com.guru.cocktails.domain.repository.MyIngredientsRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    internal fun cocktailsRepository(repository: CocktailsRepositoryImpl): CocktailsRepository {
        return repository
    }

    @Singleton
    @Provides
    internal fun ingredientsRepository(repository: IngredientsRepositoryImpl): IngredientsRepository {
        return repository
    }

    @Singleton
    @Provides
    internal fun myIngredientsRepository(repository: MyIngredientsRepositoryImpl): MyIngredientsRepository {
        return repository
    }

    @Provides
    @Singleton
    internal fun provideRemoteSource(retrofit: Retrofit): RemoteSource {
        return CocktailsRemoteSource(retrofit)
    }

    @Provides
    @Singleton
    internal fun provideLocalSource(db: CocktailsDatabase): LocalSource {
        return LocalSourceImpl(db)
    }

    @Provides
    @Singleton
    internal fun provideRoomDb(context: Context): CocktailsDatabase {
        return Room.databaseBuilder(context, CocktailsDatabase::class.java, "cocktails_db").build()
    }
}
