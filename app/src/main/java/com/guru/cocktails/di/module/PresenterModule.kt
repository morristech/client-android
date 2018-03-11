package com.guru.cocktails.di.module

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.CocktailsUseCase
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListContract
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListPresenter
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailListPresenter
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailsListContract
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @ViewScope
    @Provides
    internal fun ingredientsPresenter(ingredientsUseCase: IngredientsUseCase): IngredientListContract.Presenter {
        return IngredientListPresenter(ingredientsUseCase)
    }

    @ViewScope
    @Provides
    internal fun cocktailListPresenter(useCase: CocktailsUseCase): CocktailsListContract.Presenter {
        return CocktailListPresenter(useCase)
    }
}
