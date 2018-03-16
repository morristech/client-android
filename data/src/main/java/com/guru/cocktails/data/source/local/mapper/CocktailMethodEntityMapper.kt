package com.guru.cocktails.data.source.local.mapper

import com.guru.cocktails.data.source.local.model.CocktailMethodEntity
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.cocktail.CocktailMethod
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CocktailMethodEntityMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String
) : Mapper<CocktailMethod, CocktailMethodEntity>() {

    override fun map(from: CocktailMethodEntity) = with(from) {
        CocktailMethod(
            id = id,
            name = name,
            description = description
        )
    }

    override fun reverse(to: CocktailMethod) = with(to) {
        CocktailMethodEntity(
            id = id,
            name = name,
            description = description
        )
    }
}