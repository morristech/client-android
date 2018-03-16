package com.guru.cocktails.data.source.local.mapper

import com.guru.cocktails.data.source.local.model.CocktailGlassEntity
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.cocktail.CocktailGlass
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CocktailGlassEntityMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String
) : Mapper<CocktailGlass, CocktailGlassEntity>() {

    override fun map(from: CocktailGlassEntity) = with(from) {
        CocktailGlass(
            id = id,
            name = name
        )
    }

    override fun reverse(to: CocktailGlass) = with(to) {
        CocktailGlassEntity(
            id = id,
            name = name
        )
    }
}