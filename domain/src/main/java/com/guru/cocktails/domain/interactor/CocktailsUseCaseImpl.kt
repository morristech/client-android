package com.guru.cocktails.domain.interactor

import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.interactor.definition.CocktailsUseCase
import com.guru.cocktails.domain.model.cocktail.CocktailDetailBundle
import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import com.guru.cocktails.domain.repository.CocktailsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailsUseCaseImpl
@Inject
constructor(
    private val schedulerProvider: SchedulerProvider,
    private val repository: CocktailsRepository
) : CocktailsUseCase {

    override fun getCocktailsList(): Flowable<List<CocktailThumb>> =
        repository
            .getCocktailsList()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())

    override fun refreshCocktailsList(): Completable =
        repository
            .refreshCocktailsList()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())

    override fun getCocktailDetail(id: Int): Flowable<CocktailDetailBundle> =
        repository
            .getCocktailDetail(id)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())

    override fun refreshCocktailDetail(id: Int): Completable =
        repository
            .refreshCocktailDetail(id)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
}
