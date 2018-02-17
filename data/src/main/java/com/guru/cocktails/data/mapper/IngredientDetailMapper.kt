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

    override fun map(from: IngredientDetailDto) = IngredientDetail(
            id = from.id ?: invalidInt,
            name = from.name ?: emptyString,
            nameGrouped = from.nameGrouped ?: emptyString,
            description = from.description ?: emptyString,
            imageName = from.imageName ?: emptyString,
            numShowed = from.numShowed ?: invalidInt,
            ingredientType = ingredientTypeMapper.map(from.ingredientType?: IngredientTypeDto(invalidInt,emptyString)),
            voltage = from.voltage ?: invalidInt)

    override fun reverse(to: IngredientDetail) = IngredientDetailDto(
            id = to.id,
            name = to.name,
            nameGrouped = to.nameGrouped,
            description = to.description,
            imageName = to.imageName,
            numShowed = to.numShowed,
            ingredientType = ingredientTypeMapper.reverse(to.ingredientType),
            voltage = to.voltage)
}