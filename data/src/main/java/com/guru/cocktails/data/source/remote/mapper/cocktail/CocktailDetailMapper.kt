package com.guru.cocktails.data.source.remote.mapper.cocktail

import com.guru.cocktails.data.source.remote.model.cocktail.CocktailDetailDto
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.cocktail.CocktailDetail
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CocktailDetailMapper
@Inject constructor(
    @Named("baseUrl") private val baseUrl: String,
    private val cocktailGlassMapper: CocktailGlassMapper,
    private val cocktailMethodMapper: CocktailMethodMapper
) : Mapper<CocktailDetail, CocktailDetailDto>() {

    override fun map(from: CocktailDetailDto) = with(from) {
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
            glass = cocktailGlassMapper.map(glass),
            method = cocktailMethodMapper.map(method),
            ingredientList = ingredientList,
            similarCocktailList = similarCocktailList,
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
        CocktailDetailDto(
            id = id,
            name = name,
            totalVolume = totalVolume,
            alcoVolume = alcoVolume,
            nonAlcoVolume = nonAlcoVolume,
            instructions = instructions,
            garnish = garnish,
            description = description,
            imageName = imageName,
            glass = cocktailGlassMapper.reverse(glass),
            method = cocktailMethodMapper.reverse(method),
            ingredientList = ingredientList,
            similarCocktailList = similarCocktailList,
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