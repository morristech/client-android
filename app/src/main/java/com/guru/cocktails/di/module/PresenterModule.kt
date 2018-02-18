package com.guru.cocktails.di.module

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.ui.academy.holder.AcademyHolderContract
import com.guru.cocktails.ui.academy.holder.AcademyHolderPresenter
import com.guru.cocktails.ui.bar.holder.BarHolderContract
import com.guru.cocktails.ui.bar.holder.BarHolderPresenter
import com.guru.cocktails.ui.bar.ingredients.IngredientsContract
import com.guru.cocktails.ui.bar.ingredients.IngredientsPresenter
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderContract
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderPresenter
import com.guru.cocktails.ui.ingredient.IngredientContract
import com.guru.cocktails.ui.ingredient.IngredientPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @ViewScope
    @Provides
    internal fun ingredientPresenter(ingredientsUseCase: IngredientsUseCase): IngredientContract.Presenter {
        return IngredientPresenter(ingredientsUseCase)
    }

    @ViewScope
    @Provides
    internal fun academyHolderPresenter(ingredientsUseCase: IngredientsUseCase): AcademyHolderContract.Presenter {
        return AcademyHolderPresenter(ingredientsUseCase)
    }

    @ViewScope
    @Provides
    internal fun cocktailsHolderPresenter(ingredientsUseCase: IngredientsUseCase): CocktailsHolderContract.Presenter {
        return CocktailsHolderPresenter(ingredientsUseCase)
    }

    @ViewScope
    @Provides
    internal fun barHolderPresenter(ingredientsUseCase: IngredientsUseCase): BarHolderContract.Presenter {
        return BarHolderPresenter(ingredientsUseCase)
    }

    @ViewScope
    @Provides
    internal fun ingredientsPresenter(ingredientsUseCase: IngredientsUseCase): IngredientsContract.Presenter {
        return IngredientsPresenter(ingredientsUseCase)
    }
}
