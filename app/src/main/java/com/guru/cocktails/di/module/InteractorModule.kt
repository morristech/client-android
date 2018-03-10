package com.guru.cocktails.di.module

import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.interactor.CocktailsUseCaseImpl
import com.guru.cocktails.domain.interactor.IngredientsUseCaseImpl
import com.guru.cocktails.domain.interactor.definition.CocktailsUseCase
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.domain.repository.CocktailsRepository
import com.guru.cocktails.domain.repository.IngredientsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class InteractorModule {

    @Singleton
    @Provides
    internal fun ingredientsUseCaseImpl(schedulerProvider: SchedulerProvider, repository: IngredientsRepository): IngredientsUseCase {
        return IngredientsUseCaseImpl(schedulerProvider, repository)
    }

    @Singleton
    @Provides
    internal fun cocktailsUseCaseImpl(schedulerProvider: SchedulerProvider, repository: CocktailsRepository): CocktailsUseCase {
        return CocktailsUseCaseImpl(schedulerProvider, repository)
    }
}
