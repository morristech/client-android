package com.guru.cocktails.data.source.local.mapper

import com.guru.cocktails.data.source.local.model.CocktailDetailBundleEntity
import com.guru.cocktails.domain.model.cocktail.CocktailDetailBundle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailDetailBundleEntityMapper
@Inject constructor(
    private val cocktailDetailEntityMapper: CocktailDetailEntityMapper,
    private val cocktailGlassEntityMapper: CocktailGlassEntityMapper
) {

    fun map(from: CocktailDetailBundleEntity) = with(from) {
        CocktailDetailBundle(
            cocktail = cocktailDetailEntityMapper.map(cocktail!!)
                .copy(glass = cocktailGlassEntityMapper.map(glass.first()))
        )
    }
}