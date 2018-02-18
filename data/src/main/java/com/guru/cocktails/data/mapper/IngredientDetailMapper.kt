package com.guru.cocktails.data.mapper

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.remote.model.ingredientDto.IngredientDetailDto
import com.guru.cocktails.data.source.remote.model.ingredientDto.IngredientTypeDto
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientDetailMapper @Inject constructor(
        private val ingredientTypeMapper: IngredientTypeMapper
) : Mapper<IngredientDetail, IngredientDetailDto>() {

    override fun map(from: IngredientDetailDto) = with(from) {
        IngredientDetail(
                id = id ?: invalidInt,
                name = name ?: emptyString,
                nameGrouped = nameGrouped ?: emptyString,
                description = description ?: emptyString,
                imageName = imageName ?: emptyString,
                numShowed = numShowed ?: invalidInt,
                ingredientType = ingredientTypeMapper.map(ingredientType ?: IngredientTypeDto(invalidInt, emptyString)),
                voltage = voltage ?: invalidInt)
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
                voltage = voltage)
    }
}