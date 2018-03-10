package com.guru.cocktails.data.source.remote.mapper.cocktail

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.remote.model.cocktail.CocktailThumbDto
import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CocktailThumbMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String
) : Mapper<CocktailThumb, CocktailThumbDto>() {

    override fun map(from: CocktailThumbDto) = with(from) {
        CocktailThumb(
            id = id ?: INVALID_INT,
            name = name ?: EMPTY_STRING,
            image = image ?: EMPTY_STRING,
            imageUrl = "${baseUrl}assets/cock/thumb_300/$image",
            alcoVolume = alcoVolume ?: INVALID_DOUBLE,
            calculatedRating = calculatedRating ?: INVALID_DOUBLE,
            numOfFavorite = numOfFavorite ?: 0
        )
    }

    override fun reverse(to: CocktailThumb) = with(to) {
        CocktailThumbDto(
            id = id,
            name = name,
            image = image,
            alcoVolume = alcoVolume,
            calculatedRating = calculatedRating,
            numOfFavorite = numOfFavorite
        )
    }
}