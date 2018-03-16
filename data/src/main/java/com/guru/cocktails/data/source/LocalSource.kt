package com.guru.cocktails.data.source

import com.guru.cocktails.data.source.local.model.*
import io.reactivex.Completable
import io.reactivex.Flowable

interface LocalSource {

    /* My Ingredients */
    fun getMyIngredients(): Flowable<List<MyIngredientEntity>>

    fun getShoppingList(): Flowable<List<MyIngredientEntity>>

    fun getMyIngredientById(ingredientId: Int): Flowable<MyIngredientEntity>

    fun addMyIngredient(item: MyIngredientEntity): Completable

    fun deleteMyIngredient(item: MyIngredientEntity): Completable

    /* Ingredients */
    fun getAllAlcoholic(): Flowable<List<IngredientThumbEntity>>

    fun getAllNonAlcoholic(): Flowable<List<IngredientThumbEntity>>

    fun saveIngredientsThumb(item: List<IngredientThumbEntity>): Completable

    fun getIngredientDetail(id: Int): Flowable<IngredientDetailEntity>

    fun saveIngredientDetail(item: IngredientDetailEntity): Completable

    /* Cocktails */
    fun getCocktailsList(): Flowable<List<CocktailThumbEntity>>

    fun saveCocktailsList(list: List<CocktailThumbEntity>): Completable

    fun getCocktailDetail(id: Int): Flowable<CocktailDetailBundleEntity>

    fun saveCocktailDetail(item: CocktailDetailEntity): Completable

    /* Various */
    fun getCocktailGlassDetail(id: Int): Flowable<CocktailGlassEntity>

    fun saveCocktailGlassDetail(item: CocktailGlassEntity): Completable

    fun getCocktailMethodDetail(id: Int): Flowable<CocktailMethodEntity>

    fun saveCocktailMethodDetail(item: CocktailMethodEntity): Completable
}
