package com.guru.cocktails.domain.interactor.definition

import com.guru.cocktails.domain.model.cocktail.CocktailDetailBundle
import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import io.reactivex.Completable
import io.reactivex.Flowable

interface CocktailsUseCase {

    fun getCocktailsList(): Flowable<List<CocktailThumb>>

    fun refreshCocktailsList(): Completable

    fun getCocktailDetail(id: Int): Flowable<CocktailDetailBundle>

    fun refreshCocktailDetail(id: Int): Completable
}