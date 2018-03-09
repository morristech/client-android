package com.guru.cocktails.domain.interactor

import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.repository.IngredientsRepository
import io.reactivex.Completable
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

    override fun getAllAlcoholicIngredients(): Flowable<List<IngredientThumb>> = repository
        .getAllAlcoholicIngredients()
        .subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())

    override fun refreshAllAlcoholicIngredients(): Completable = repository
        .refreshAllAlcoholicIngredients()
        .subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())

    override fun getAllNonAlcoholicIngredients(): Flowable<List<IngredientThumb>> = repository
        .getAllNonAlcoholicIngredients()
        .subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())

    override fun refreshAllNonAlcoholicIngredients(): Completable = repository
        .refreshAllNonAlcoholicIngredients()
        .subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())

    override fun getIngredientDetail(id: Int): Flowable<IngredientDetail> = repository
        .getIngredientDetail(id)
        .subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())

    override fun refreshIngredientDetail(id: Int): Completable = repository
        .refreshIngredientDetail(id)
        .subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())
}
