package com.guru.cocktails.data.repository

import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.local.mapper.MyIngredientEntityMapper
import com.guru.cocktails.domain.model.ingredient.MyIngredient
import com.guru.cocktails.domain.repository.MyIngredientsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyIngredientsRepositoryImpl
@Inject
constructor(
    private val localSource: LocalSource,
    private val myIngredientEntityMapper: MyIngredientEntityMapper
) : MyIngredientsRepository {

    override fun getMyIngredientById(id: Int): Flowable<MyIngredient> =
        localSource
            .getMyIngredientById(id)
            .map { myIngredientEntityMapper.map(it) }

    override fun getMyIngredients(): Flowable<List<MyIngredient>> =
        localSource
            .getMyIngredients()
            .map { myIngredientEntityMapper.map(it) }

    override fun addMyIngredient(item: MyIngredient): Completable =
        myIngredientEntityMapper
            .reverse(item)
            .let { localSource.addMyIngredient(it) }

    override fun removeMyIngredient(item: MyIngredient): Completable =
        myIngredientEntityMapper
            .reverse(item)
            .let { localSource.deleteMyIngredient(it) }
}
