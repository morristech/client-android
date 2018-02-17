package com.guru.cocktails.data.mapper

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.remote.model.ingredientDto.IngredientTypeDto
import com.guru.cocktails.domain.model.ingredient.IngredientType
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class IngredientTypeMapper @Inject constructor() : Mapper<IngredientType, IngredientTypeDto>() {

    override fun map(from: IngredientTypeDto) = IngredientType(
            id = from.id ?: invalidInt,
            name = from.name ?: emptyString
    )

    override fun reverse(to: IngredientType) = IngredientTypeDto(
            to.id, to.name
    )
}