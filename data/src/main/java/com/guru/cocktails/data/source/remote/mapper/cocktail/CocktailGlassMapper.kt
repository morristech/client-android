package com.guru.cocktails.data.source.remote.mapper.cocktail

import com.guru.cocktails.data.source.remote.model.cocktail.CocktailGlassDto
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.cocktail.CocktailGlass
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CocktailGlassMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String
) : Mapper<CocktailGlass, CocktailGlassDto>() {

    override fun map(from: CocktailGlassDto) = with(from) {
        CocktailGlass(
            id = id,
            name = name
        )
    }

    override fun reverse(to: CocktailGlass) = with(to) {
        CocktailGlassDto(
            id = id,
            name = name
        )
    }
}