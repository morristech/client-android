package com.guru.cocktails.data.mapper

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientThumbDto
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class IngredientThumbMapper
@Inject constructor(@Named("baseUrl") private val baseUrl: String) : Mapper<IngredientThumb, IngredientThumbDto>() {

    override fun map(from: IngredientThumbDto) = with(from) {
        IngredientThumb(
            id = id ?: INVALID_INT,
            name = nameGrouped ?: EMPTY_STRING,
            imageName = imageName ?: EMPTY_STRING,
            imageUrl = "${baseUrl}assets/ingred/thumb_300/$imageName",
            voltage = voltage ?: INVALID_DOUBLE
        )
    }

    override fun reverse(to: IngredientThumb) = with(to) {
        IngredientThumbDto(
            id = id,
            nameGrouped = name,
            imageName = imageUrl,
            voltage = voltage
        )
    }
}