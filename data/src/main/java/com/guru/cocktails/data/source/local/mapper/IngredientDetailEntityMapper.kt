package com.guru.cocktails.data.source.local.mapper

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.local.model.IngredientDetailEntity
import com.guru.cocktails.data.source.remote.mapper.IngredientTypeMapper
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientTypeDto
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class IngredientDetailEntityMapper
@Inject constructor(
    private val ingredientTypeMapper: IngredientTypeMapper,
    @Named("baseUrl") private val baseUrl: String
) : Mapper<IngredientDetail, IngredientDetailEntity>() {

    override fun map(from: IngredientDetailEntity) = with(from) {
        IngredientDetail(
            id = id,
            name = name,
            nameGrouped = nameGrouped,
            description = description,
            imageName = imageName,
            imageUrl = "${baseUrl}assets/ingred/full/$imageName",
            numShowed = numShowed,
            ingredientType = ingredientTypeMapper.map(IngredientTypeDto(ingredientTypeId, ingredientTypeName)),
            voltage = voltage
        )
    }

    override fun reverse(to: IngredientDetail) = with(to) {
        IngredientDetailEntity(
            id = id,
            name = name,
            nameGrouped = nameGrouped,
            description = description,
            imageName = imageName,
            numShowed = numShowed,
            ingredientTypeId = ingredientType.id,
            ingredientTypeName = ingredientType.name,
            voltage = voltage
        )
    }
}