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
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @ViewScope
    @Provides
    internal fun academyHolderPresenter(ingredientsUseCase: IngredientsUseCase): AcademyHolderContract.Presenter {
        return AcademyHolderPresenter(ingredientsUseCase)
    }

    @ViewScope
    @Provides
    internal fun cocktailsHolderPresenter(): CocktailsHolderContract.Presenter {
        return CocktailsHolderPresenter()
    }

    @ViewScope
    @Provides
    internal fun barHolderPresenter(): BarHolderContract.Presenter {
        return BarHolderPresenter()
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
