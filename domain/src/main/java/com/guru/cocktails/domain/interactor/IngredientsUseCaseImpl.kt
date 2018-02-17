package com.guru.cocktails.domain.interactor

import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.repository.IngredientsRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientsUseCaseImpl
@Inject
constructor(
    private val schedulerProvider: SchedulerProvider,
    private val repository: IngredientsRepository
) : IngredientsUseCase {

    override fun getNonAlcoList(): Flowable<ListBundle<IngredientThumb>> {
        return repository.getNonAlcoList().subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
    }
}
