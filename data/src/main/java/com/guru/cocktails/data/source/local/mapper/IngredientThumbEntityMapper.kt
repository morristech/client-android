package com.guru.cocktails.data.source.local.mapper

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.local.model.IngredientThumbEntity
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class IngredientThumbEntityMapper
@Inject constructor(@Named("baseUrl") private val baseUrl: String) : Mapper<IngredientThumb, IngredientThumbEntity>() {

    override fun map(from: IngredientThumbEntity) = with(from) {
        IngredientThumb(
            id = id,
            name = name,
            imageUrl = "${baseUrl}assets/ingred/thumb_300/$imageName",
            imageName = imageName,
            voltage = voltage
        )
    }

    override fun reverse(to: IngredientThumb) = with(to) {
        IngredientThumbEntity(
            id = id,
            name = name,
            imageName = imageName,
            voltage = voltage
        )
    }
}