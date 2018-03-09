package com.guru.cocktails.di.module

import com.guru.cocktails.data.source.remote.mapper.IngredientDetailMapper
import com.guru.cocktails.data.source.remote.mapper.IngredientThumbMapper
import com.guru.cocktails.data.source.remote.mapper.IngredientTypeMapper
import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientThumbDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientTypeDto
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.model.ingredient.IngredientType
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {


    @Singleton
    @Provides
    internal fun ingredientDetailMapper(mapper: IngredientDetailMapper): Mapper<IngredientDetail, IngredientDetailDto> {
        return mapper
    }

    @Singleton
    @Provides
    internal fun ingredientTypeMapper(mapper: IngredientTypeMapper): Mapper<IngredientType, IngredientTypeDto> {
        return mapper
    }

    @Singleton
    @Provides
    internal fun ingredientThumbMapper(mapper: IngredientThumbMapper): Mapper<IngredientThumb, IngredientThumbDto> {
        return mapper
    }
}