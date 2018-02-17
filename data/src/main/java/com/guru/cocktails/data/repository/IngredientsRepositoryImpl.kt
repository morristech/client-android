package com.guru.cocktails.data.repository

import com.guru.cocktails.data.mapper.IngredientDetailMapper
import com.guru.cocktails.data.mapper.IngredientTypeMapper
import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.remote.model.ingredientDto.IngredientDetailDto
import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.model.ingredient.IngredientType
import com.guru.cocktails.domain.repository.IngredientsRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientsRepositoryImpl
@Inject
constructor(
        private val remoteSource: RemoteSource,
        private val localSource: LocalSource,
        private val ingredientDetailDtoMapper: IngredientDetailMapper,
        private val ingredientTypeDtoMapper: IngredientTypeMapper) :
        IngredientsRepository {

    override fun getIngredientDetailForRemote(ingredientId: Int): Single<IngredientDetail> {
        return remoteSource
                .getIngredientDetailForRemote(ingredientId)
                .map { ingredientDetailDtoMapper.map(it) }
    }

    override fun getNonAlcoList(): Flowable<ListBundle<IngredientThumb>> {
        return remoteSource.getNonAlcoList().toFlowable()
    }

}
