package com.guru.cocktails.data.repository

import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.local.mapper.CocktailThumbEntityMapper
import com.guru.cocktails.data.source.remote.mapper.cocktail.CocktailThumbMapper
import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import com.guru.cocktails.domain.repository.CocktailsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailsRepositoryImpl
@Inject
constructor(
    private val remoteSource: RemoteSource,
    private val localSource: LocalSource,
    private val cocktailThumbMapper: CocktailThumbMapper,
    private val cocktailThumbEntityMapper: CocktailThumbEntityMapper
) : CocktailsRepository {

    override fun getCocktailsList(): Flowable<List<CocktailThumb>> =
        localSource
            .getCocktailsList()
            .map { cocktailThumbEntityMapper.map(it) }

    override fun saveCocktailsList(list: List<CocktailThumb>): Completable =
        localSource
            .saveCocktailsList(cocktailThumbEntityMapper.reverse(list))

    override fun refreshCocktailsList(): Completable =
        remoteSource
            .getCocktailsList()
            .map { cocktailThumbMapper.map(it.list) }
            .flatMapCompletable { saveCocktailsList(it) }
}
