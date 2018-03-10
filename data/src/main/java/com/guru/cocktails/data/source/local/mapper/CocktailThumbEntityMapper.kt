package com.guru.cocktails.data.source.local.mapper

import com.guru.cocktails.data.source.local.model.CocktailThumbEntity
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CocktailThumbEntityMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String
) : Mapper<CocktailThumb, CocktailThumbEntity>() {

    override fun map(from: CocktailThumbEntity) = with(from) {
        CocktailThumb(
            id = id,
            name = name,
            image = image,
            imageUrl = "${baseUrl}assets/cock/thumb_300/$image",
            numOfFavorite = numOfFavorite,
            calculatedRating = calculatedRating,
            alcoVolume = alcoVolume
        )
    }

    override fun reverse(to: CocktailThumb) = with(to) {
        CocktailThumbEntity(
            id = id,
            name = name,
            image = image,
            alcoVolume = alcoVolume,
            calculatedRating = calculatedRating,
            numOfFavorite = numOfFavorite
        )
    }
}