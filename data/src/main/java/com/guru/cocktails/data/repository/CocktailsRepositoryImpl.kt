package com.guru.cocktails.data.repository

import com.guru.cocktails.data.source.LocalSource
import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.local.mapper.CocktailDetailBundleEntityMapper
import com.guru.cocktails.data.source.local.mapper.CocktailDetailEntityMapper
import com.guru.cocktails.data.source.local.mapper.CocktailGlassEntityMapper
import com.guru.cocktails.data.source.local.mapper.CocktailThumbEntityMapper
import com.guru.cocktails.data.source.remote.mapper.cocktail.CocktailDetailBundleMapper
import com.guru.cocktails.data.source.remote.mapper.cocktail.CocktailThumbMapper
import com.guru.cocktails.domain.model.cocktail.CocktailDetailBundle
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
    private val cocktailThumbEntityMapper: CocktailThumbEntityMapper,
    private val cocktailDetailBundleMapper: CocktailDetailBundleMapper,
    private val cocktailDetailEntityMapper: CocktailDetailEntityMapper,
    private val cocktailGlassEntityMapper: CocktailGlassEntityMapper,
    private val cocktailDetailBundleEntityMapper: CocktailDetailBundleEntityMapper
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

    /* Cocktail Detail*/
    override fun getCocktailDetail(id: Int): Flowable<CocktailDetailBundle> {
        return localSource
            .getCocktailDetail(id)
            .map { cocktailDetailBundleEntityMapper.map(it) }
    }

    //TODO do not save/update method/glass decriptions, once we laod all methods/glasses upon initial app start
    override fun saveCocktailDetail(item: CocktailDetailBundle): Completable {
        val cocktailEntity = cocktailDetailEntityMapper.reverse(item.cocktail)
        val glassEntity = cocktailGlassEntityMapper.reverse(item.cocktail.glass)
        return localSource
            .saveCocktailDetail(cocktailEntity)
            .andThen(localSource.saveCocktailGlassDetail(glassEntity))
    }

    override fun refreshCocktailDetail(id: Int): Completable {
        return remoteSource
            .getCocktailDetail(id)
            .map { cocktailDetailBundleMapper.map(it) }
            .flatMapCompletable { saveCocktailDetail(it) }
    }
}
