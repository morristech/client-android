package com.guru.cocktails.di.module

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.CocktailsUseCase
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailListPresenter
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailsListContract
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @ViewScope
    @Provides
    internal fun cocktailListPresenter(useCase: CocktailsUseCase): CocktailsListContract.Presenter {
        return CocktailListPresenter(useCase)
    }
}
