package com.guru.cocktails.data.source.remote.mapper.cocktail

import com.guru.cocktails.data.source.remote.model.cocktail.CocktailDetailBundleDto
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.cocktail.CocktailDetailBundle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailDetailBundleMapper
@Inject constructor(
    private val cocktailDetailMapper: CocktailDetailMapper
) : Mapper<CocktailDetailBundle, CocktailDetailBundleDto>() {

    override fun map(from: CocktailDetailBundleDto) = with(from) {
        CocktailDetailBundle(
            cocktail = cocktailDetailMapper.map(cocktail)
        )
    }

    override fun reverse(to: CocktailDetailBundle) = with(to) {
        CocktailDetailBundleDto(
            cocktail = cocktailDetailMapper.reverse(cocktail)
        )
    }
}