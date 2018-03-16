package com.guru.cocktails.data.source.local.mapper

import com.google.gson.Gson
import com.guru.cocktails.data.extension.fromJson
import com.guru.cocktails.data.source.local.model.CocktailDetailEntity
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.cocktail.CocktailDetail
import com.guru.cocktails.domain.model.cocktail.CocktailGlass
import com.guru.cocktails.domain.model.cocktail.CocktailMethod
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CocktailDetailEntityMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String,
    private val gson: Gson
) : Mapper<CocktailDetail, CocktailDetailEntity>() {

    override fun map(from: CocktailDetailEntity) = with(from) {
        CocktailDetail(
            id = id,
            name = name,
            totalVolume = totalVolume,
            alcoVolume = alcoVolume,
            nonAlcoVolume = nonAlcoVolume,
            instructions = instructions,
            garnish = garnish,
            description = description,
            imageName = imageName,
            imageUrl = "${baseUrl}assets/cock/full/$imageName",
            glass = CocktailGlass.EMPTY,
            method = CocktailMethod.EMPTY,
            ingredientList = gson.fromJson<List<Long>>(ingredientList),
            similarCocktailList = gson.fromJson<List<Long>>(similarCocktailList),
            numOfFavorite = numOfFavorite,
            calculatedRating = calculatedRating,
            numRating1 = numRating1,
            numRating2 = numRating2,
            numRating3 = numRating3,
            numRating4 = numRating4,
            numRating5 = numRating5,
            alcoholVolume = alcoholVolume,
            numPictures = numPictures,
            numComments = numComments,
            numShowed = numShowed
        )
    }

    override fun reverse(to: CocktailDetail) = with(to) {
        CocktailDetailEntity(
            id = id,
            name = name,
            totalVolume = totalVolume,
            alcoVolume = alcoVolume,
            nonAlcoVolume = nonAlcoVolume,
            instructions = instructions,
            garnish = garnish,
            description = description,
            imageName = imageName,
            glassId = glass.id,
            methodId = method.id,
            ingredientList = gson.toJson(ingredientList),
            similarCocktailList = gson.toJson(similarCocktailList),
            numOfFavorite = numOfFavorite,
            calculatedRating = calculatedRating,
            numRating1 = numRating1,
            numRating2 = numRating2,
            numRating3 = numRating3,
            numRating4 = numRating4,
            numRating5 = numRating5,
            alcoholVolume = alcoholVolume,
            numPictures = numPictures,
            numComments = numComments,
            numShowed = numShowed
        )
    }
}