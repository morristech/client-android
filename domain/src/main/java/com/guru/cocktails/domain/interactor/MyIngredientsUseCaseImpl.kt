package com.guru.cocktails.domain.interactor

import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.interactor.definition.MyIngredientsUseCase
import com.guru.cocktails.domain.model.ingredient.MyIngredient
import com.guru.cocktails.domain.repository.MyIngredientsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyIngredientsUseCaseImpl
@Inject
constructor(
    private val schedulerProvider: SchedulerProvider,
    private val repository: MyIngredientsRepository
) : MyIngredientsUseCase {

    override fun getMyIngredientById(id: Int): Flowable<MyIngredient> =
        repository
            .getMyIngredientById(id)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())

    override fun getMyIngredients(): Flowable<List<MyIngredient>> =
        repository
            .getMyIngredients()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())

    override fun addToMyBar(item: MyIngredient): Completable =
        repository
            .addMyIngredient(item)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())

    override fun removeFromMyBar(item: MyIngredient): Completable =
        resolveCompletable(item)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())

    override fun addToShoppingList(item: MyIngredient): Completable =
        repository
            .addMyIngredient(item)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())

    override fun removeFromShoppingList(item: MyIngredient): Completable =
        resolveCompletable(item)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())

    private fun resolveCompletable(item: MyIngredient): Completable =
        if (item.shoppingCart || item.myBar) {
            repository.addMyIngredient(item)
        } else {
            repository.removeMyIngredient(item)
        }
}
