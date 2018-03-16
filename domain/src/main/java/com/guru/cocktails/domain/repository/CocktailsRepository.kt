package com.guru.cocktails.domain.repository

import com.guru.cocktails.domain.model.cocktail.CocktailDetailBundle
import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import io.reactivex.Completable
import io.reactivex.Flowable

interface CocktailsRepository {

    fun getCocktailsList(): Flowable<List<CocktailThumb>>

    fun saveCocktailsList(list: List<CocktailThumb>): Completable

    fun refreshCocktailsList(): Completable

    /* Cocktail Detail*/
    fun getCocktailDetail(id: Int): Flowable<CocktailDetailBundle>

    fun saveCocktailDetail(item: CocktailDetailBundle): Completable

    fun refreshCocktailDetail(id: Int): Completable
}
