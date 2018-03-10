package com.guru.cocktails.di.module

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.CocktailsUseCase
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.ui.academy.holder.AcademyHolderContract
import com.guru.cocktails.ui.academy.holder.AcademyHolderPresenter
import com.guru.cocktails.ui.bar.holder.BarHolderContract
import com.guru.cocktails.ui.bar.holder.BarHolderPresenter
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListContract
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListPresenter
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailListPresenter
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailsListContract
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderContract
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderPresenter
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailContract
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @ViewScope
    @Provides
    internal fun ingredientPresenter(ingredientsUseCase: IngredientsUseCase): IngredientDetailContract.Presenter {
        return IngredientDetailPresenter(ingredientsUseCase)
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
    internal fun ingredientsPresenter(ingredientsUseCase: IngredientsUseCase): IngredientListContract.Presenter {
        return IngredientListPresenter(ingredientsUseCase)
    }

    @ViewScope
    @Provides
    internal fun cocktailListPresenter(useCase: CocktailsUseCase): CocktailsListContract.Presenter {
        return CocktailListPresenter(useCase)
    }
}
