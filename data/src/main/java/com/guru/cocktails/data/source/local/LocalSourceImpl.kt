package com.guru.cocktails.data.source.local


import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.local.mapper.IngredientThumbEntityMapper
import com.guru.cocktails.data.source.local.model.IngredientThumbEntity
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalSourceImpl
@Inject
constructor(
    private val db: CocktailsDatabase,
    private val ingredientThumbEntityMapper: IngredientThumbEntityMapper
) : LocalSource {

    override fun getAllAlcoholic(): Flowable<List<IngredientThumbEntity>> = db.ingredientThumbDao().getAllAlcoholic()

    override fun getAllNonAlcoholic(): Flowable<List<IngredientThumbEntity>> = db.ingredientThumbDao().getAllNonAlcoholic()

    override fun saveIngredientsThumb(items: List<IngredientThumb>): Completable {
        return Completable.fromCallable {
            val item = ingredientThumbEntityMapper.reverse(items)
            db.ingredientThumbDao().insertOrReplace(item)
        }
    }
}
