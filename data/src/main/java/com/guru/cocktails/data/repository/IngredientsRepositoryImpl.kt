package com.guru.cocktails.data.repository

import com.guru.cocktails.data.mapper.IngredientDetailMapper
import com.guru.cocktails.data.mapper.IngredientThumbMapper
import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.local.mapper.IngredientThumbEntityMapper
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
    private val ingredientDetailDtoMapper: IngredientDetailMapper,
    private val ingredientThumbMapper: IngredientThumbMapper,
    private val ingredientThumbEntityMapper: IngredientThumbEntityMapper
) : IngredientsRepository {

    override fun getAllAlcoholicIngredients(): Flowable<List<IngredientThumb>> = localSource
        .getAllAlcoholic()
        .map { ingredientThumbEntityMapper.map(it) }
        .map { it.sortedBy { it.name } }

    override fun getAllNonAlcoholicIngredients(): Flowable<List<IngredientThumb>> = localSource
        .getAllNonAlcoholic()
        .map { ingredientThumbEntityMapper.map(it) }
        .map { it.sortedBy { it.name } }

    override fun getIngredientDetail(ingredientId: Int): Flowable<IngredientDetail> = remoteSource
        .getIngredientDetail(ingredientId)
        .map { ingredientDetailDtoMapper.map(it) }
        .toFlowable()

    override fun saveAllAlcoholicIngredients(list: List<IngredientThumb>): Completable = localSource.saveIngredientsThumb(list)

    override fun saveAllNonAlcoholicIngredients(list: List<IngredientThumb>): Completable = localSource.saveIngredientsThumb(list)

    //TODO remove  .map { it.filter { it.voltage > 0.0 } } once api return only desired items
    override fun refreshAllAlcoholicIngredients(): Completable = remoteSource
        .getIngredientList()
        .map { ingredientThumbMapper.map(it.ingredientList) }
        .map { it.filter { it.voltage > 0.0 } }
        .flatMapCompletable { saveAllAlcoholicIngredients(it) }

    //TODO remove  .map { it.filter { it.voltage > 0.0 } } once api return only desired items
    override fun refreshAllNonAlcoholicIngredients(): Completable = remoteSource
        .getIngredientList()
        .map { ingredientThumbMapper.map(it.ingredientList) }
        .map { it.filter { it.voltage == 0.0 } }
        .flatMapCompletable { saveAllNonAlcoholicIngredients(it) }
}
