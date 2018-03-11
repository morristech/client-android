package com.guru.cocktails.ui.ingredientdetail.di

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.domain.interactor.definition.MyIngredientsUseCase
import com.guru.cocktails.domain.model.mapper.MyIngredientMapper
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailContract
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class IngredientDetailModule(private val ingredientId: Int) {

    @ViewScope
    @Provides
    @Named("ingredientId")
    internal fun context(): Int {
        return ingredientId
    }

    @ViewScope
    @Provides
    internal fun ingredientPresenter(
        ingredientsUseCase: IngredientsUseCase,
        myIngredientsUseCase: MyIngredientsUseCase,
        myIngredientMapper: MyIngredientMapper,
        @Named("ingredientId") ingredientId: Int
    ): IngredientDetailContract.Presenter {
        return IngredientDetailPresenter(
            ingredientsUseCase = ingredientsUseCase,
            myIngredientMapper = myIngredientMapper,
            myIngredientsUseCase = myIngredientsUseCase,
            ingredientId = ingredientId
        )
    }
}
