package com.guru.cocktails.data.repository

import com.guru.cocktails.data.mapper.IngredientDetailMapper
import com.guru.cocktails.data.mapper.IngredientThumbMapper
import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.repository.IngredientsRepository
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
    private val ingredientThumbMapper: IngredientThumbMapper
) : IngredientsRepository {

    override fun getAllAlcoholicIngredients(): Flowable<List<IngredientThumb>> {
        return remoteSource
            .getIngredientList()
            .map { ingredientThumbMapper.map(it.ingredientList) }
            .map { it.sortedBy { it.name } }
            .toFlowable()
    }

    override fun getAllNonAlcoholicIngredients(): Flowable<List<IngredientThumb>> {
        return remoteSource
            .getIngredientList()
            .map { ingredientThumbMapper.map(it.ingredientList) }
            .map { it.sortedBy { it.name } }
            .toFlowable()
    }

    override fun getIngredientDetail(ingredientId: Int): Flowable<IngredientDetail> {
        return remoteSource
            .getIngredientDetail(ingredientId)
            .map { ingredientDetailDtoMapper.map(it) }
            .toFlowable()
    }
}
