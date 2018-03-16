package com.guru.cocktails.data.source.remote.mapper.cocktail

import com.guru.cocktails.data.source.remote.model.cocktail.CocktailMethodDto
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.cocktail.CocktailMethod
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CocktailMethodMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String
) : Mapper<CocktailMethod, CocktailMethodDto>() {

    override fun map(from: CocktailMethodDto) = with(from) {
        CocktailMethod(
            id = id,
            name = name,
            description = description
        )
    }

    override fun reverse(to: CocktailMethod) = with(to) {
        CocktailMethodDto(
            id = id,
            name = name,
            description = description
        )
    }
}