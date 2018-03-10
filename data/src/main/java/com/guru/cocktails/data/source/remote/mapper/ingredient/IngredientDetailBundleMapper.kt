package com.guru.cocktails.data.source.remote.mapper.ingredient

import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailBundleDto
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientDetailBundleMapper
@Inject constructor(
    private val ingredientDetailMapper: IngredientDetailMapper
) : Mapper<IngredientDetail, IngredientDetailBundleDto>() {

    override fun map(from: IngredientDetailBundleDto) = with(from) {
        ingredientDetailMapper.map(ingredient)
    }

    override fun reverse(to: IngredientDetail) = with(to) {
        IngredientDetailBundleDto(
            ingredient = ingredientDetailMapper.reverse(this)
        )
    }
}