package com.guru.cocktails.data.mapper

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientTypeDto
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class IngredientDetailMapper
@Inject constructor(
    private val ingredientTypeMapper: IngredientTypeMapper,
    @Named("baseUrl") private val baseUrl: String
) : Mapper<IngredientDetail, IngredientDetailDto>() {

    override fun map(from: IngredientDetailDto) = with(from) {
        IngredientDetail(
            id = id ?: INVALID_INT,
            name = name ?: EMPTY_STRING,
            nameGrouped = nameGrouped ?: EMPTY_STRING,
            description = description ?: EMPTY_STRING,
            imageName = "${baseUrl}assets/ingred/full_1000/$imageName",
            numShowed = numShowed ?: INVALID_INT,
            ingredientType = ingredientTypeMapper.map(ingredientType ?: IngredientTypeDto.EMPTY),
            voltage = voltage ?: INVALID_DOUBLE
        )
    }

    override fun reverse(to: IngredientDetail) = with(to) {
        IngredientDetailDto(
            id = id,
            name = name,
            nameGrouped = nameGrouped,
            description = description,
            imageName = imageName,
            numShowed = numShowed,
            ingredientType = ingredientTypeMapper.reverse(ingredientType),
            voltage = voltage
        )
    }
}