package com.guru.cocktails.data.source.local

import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.local.model.*
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalSourceImpl
@Inject
constructor(
    private val db: CocktailsDatabase
) : LocalSource {

    override fun getAllAlcoholic(): Flowable<List<IngredientThumbEntity>> = db.ingredientThumbDao().getAllAlcoholic()

    override fun getAllNonAlcoholic(): Flowable<List<IngredientThumbEntity>> = db.ingredientThumbDao().getAllNonAlcoholic()

    override fun saveIngredientsThumb(item: List<IngredientThumbEntity>): Completable = Completable.fromCallable {
        db.ingredientThumbDao().insertOrReplace(item)
    }

    override fun getIngredientDetail(id: Int): Flowable<IngredientDetailEntity> = db.ingredientDetailDao().getById(id)

    override fun saveIngredientDetail(item: IngredientDetailEntity): Completable = Completable.fromCallable {
        db.ingredientDetailDao().insert(item)
    }

    override fun getCocktailsList(): Flowable<List<CocktailThumbEntity>> = db.cocktailThumbDao().getAllCocktails()

    override fun saveCocktailsList(list: List<CocktailThumbEntity>): Completable = Completable.fromCallable {
        db.cocktailThumbDao().insertOrReplace(list)
    }

    override fun getMyIngredients(): Flowable<List<MyIngredientEntity>> = db.myIngredientDao().getMyIngredients()

    override fun getShoppingList(): Flowable<List<MyIngredientEntity>> = db.myIngredientDao().getShoppingList()

    override fun getMyIngredientById(ingredientId: Int): Flowable<MyIngredientEntity> =
        db.myIngredientDao().getMyIngredientById(ingredientId)

    override fun addMyIngredient(item: MyIngredientEntity): Completable = Completable.fromCallable {
        db.myIngredientDao().insert(item)
    }

    override fun deleteMyIngredient(item: MyIngredientEntity): Completable = Completable.fromCallable {
        db.myIngredientDao().delete(item)
    }

    override fun getCocktailDetail(id: Int): Flowable<CocktailDetailBundleEntity> = db.cocktailDetailBundleDao().getById(id)

    override fun saveCocktailDetail(item: CocktailDetailEntity): Completable = Completable.fromCallable {
        db.cocktailDetailDao().insert(item)
    }

    override fun getCocktailGlassDetail(id: Int): Flowable<CocktailGlassEntity> = db.cocktailGlassDao().getById(id)

    override fun saveCocktailGlassDetail(item: CocktailGlassEntity): Completable = Completable.fromCallable {
        db.cocktailGlassDao().insert(item)
    }

    override fun getCocktailMethodDetail(id: Int): Flowable<CocktailMethodEntity> = db.cocktailMethodDao().getById(id)

    override fun saveCocktailMethodDetail(item: CocktailMethodEntity): Completable = Completable.fromCallable {
        db.cocktailMethodDao().insert(item)
    }
}
