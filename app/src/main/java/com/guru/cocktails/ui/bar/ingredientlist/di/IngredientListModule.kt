package com.guru.cocktails.ui.bar.ingredientlist.di

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListContract
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListPresenter
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListType
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class IngredientListModule(private val type: IngredientListType) {

    @ViewScope
    @Provides
    @Named("ingredientListType")
    internal fun ingredientListType(): IngredientListType {
        return type
    }

    @ViewScope
    @Provides
    internal fun ingredientsPresenter(
        ingredientsUseCase: IngredientsUseCase,
        @Named("ingredientListType") ingredientListType: IngredientListType
    ): IngredientListContract.Presenter {
        return IngredientListPresenter(ingredientsUseCase, ingredientListType)
    }
}