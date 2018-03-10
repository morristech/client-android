package com.guru.cocktails.data.repository

import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.local.mapper.IngredientDetailEntityMapper
import com.guru.cocktails.data.source.local.mapper.IngredientThumbEntityMapper
import com.guru.cocktails.data.source.remote.mapper.ingredient.IngredientDetailBundleMapper
import com.guru.cocktails.data.source.remote.mapper.ingredient.IngredientThumbMapper
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.repository.IngredientsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientsRepositoryImpl
@Inject
constructor(
    private val remoteSource: RemoteSource,
    private val localSource: LocalSource,
    private val ingredientThumbMapper: IngredientThumbMapper,
    private val ingredientThumbEntityMapper: IngredientThumbEntityMapper,
    private val ingredientDetailEntityMapper: IngredientDetailEntityMapper,
    private val ingredientDetailBundleMapper: IngredientDetailBundleMapper
) : IngredientsRepository {

    /* Ingredients List Alcoholic*/
    override fun getAllAlcoholicIngredients(): Flowable<List<IngredientThumb>> = localSource
        .getAllAlcoholic()
        .map { ingredientThumbEntityMapper.map(it) }
        .map { it.sortedBy { it.name } }

    override fun saveAllAlcoholicIngredients(list: List<IngredientThumb>): Completable = localSource.saveIngredientsThumb(list)

    override fun refreshAllAlcoholicIngredients(): Completable = remoteSource
        .getAlcoIngredientList()
        .map { ingredientThumbMapper.map(it.list) }
        .flatMapCompletable { saveAllAlcoholicIngredients(it) }

    /* Ingredients List Non Alcoholic*/
    override fun getAllNonAlcoholicIngredients(): Flowable<List<IngredientThumb>> = localSource
        .getAllNonAlcoholic()
        .map { ingredientThumbEntityMapper.map(it) }
        .map { it.sortedBy { it.name } }

    override fun saveAllNonAlcoholicIngredients(list: List<IngredientThumb>): Completable = localSource.saveIngredientsThumb(list)

    override fun refreshAllNonAlcoholicIngredients(): Completable = remoteSource
        .getNonAlcoIngredientList()
        .map { ingredientThumbMapper.map(it.list) }
        .flatMapCompletable { saveAllNonAlcoholicIngredients(it) }


    /* Ingredient Detail*/
    override fun getIngredientDetail(id: Int): Flowable<IngredientDetail> = localSource
        .getIngredientDetail(id)
        .map { ingredientDetailEntityMapper.map(it) }

    override fun saveIngredientDetail(item: IngredientDetail): Completable = localSource.saveIngredientDetail(item)

    override fun refreshIngredientDetail(id: Int): Completable = remoteSource
        .getIngredientDetail(id)
        .map { ingredientDetailBundleMapper.map(it) }
        .flatMapCompletable { saveIngredientDetail(it) }
}
