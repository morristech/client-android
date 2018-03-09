package com.guru.cocktails.data.source.remote.mapper

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientTypeDto
import com.guru.cocktails.domain.model.ingredient.IngredientType
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class IngredientTypeMapper
@Inject constructor() : Mapper<IngredientType, IngredientTypeDto>() {

    override fun map(from: IngredientTypeDto) = with(from) {
        IngredientType(
            id = id ?: INVALID_INT,
            name = name ?: EMPTY_STRING
        )
    }

    override fun reverse(to: IngredientType) = with(to) {
        IngredientTypeDto(
            id = id,
            name = name
        )
    }
}