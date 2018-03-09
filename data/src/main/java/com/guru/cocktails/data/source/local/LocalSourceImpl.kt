package com.guru.cocktails.data.source.local


import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.local.mapper.IngredientDetailEntityMapper
import com.guru.cocktails.data.source.local.mapper.IngredientThumbEntityMapper
import com.guru.cocktails.data.source.local.model.IngredientDetailEntity
import com.guru.cocktails.data.source.local.model.IngredientThumbEntity
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
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
    private val ingredientThumbEntityMapper: IngredientThumbEntityMapper,
    private val ingredientDetailEntityMapper: IngredientDetailEntityMapper
) : LocalSource {

    override fun getAllAlcoholic(): Flowable<List<IngredientThumbEntity>> = db.ingredientThumbDao().getAllAlcoholic()

    override fun getAllNonAlcoholic(): Flowable<List<IngredientThumbEntity>> = db.ingredientThumbDao().getAllNonAlcoholic()

    override fun saveIngredientsThumb(item: List<IngredientThumb>): Completable {
        return Completable.fromCallable {
            val mapped = ingredientThumbEntityMapper.reverse(item)
            db.ingredientThumbDao().insertOrReplace(mapped)
        }
    }

    override fun getIngredientDetail(id: Int): Flowable<IngredientDetailEntity> = db.ingredientDetailDao().getById(id)

    override fun saveIngredientDetail(item: IngredientDetail): Completable {
        return Completable.fromCallable {
            val mapped = ingredientDetailEntityMapper.reverse(item)
            db.ingredientDetailDao().insert(mapped)
        }
    }
}
