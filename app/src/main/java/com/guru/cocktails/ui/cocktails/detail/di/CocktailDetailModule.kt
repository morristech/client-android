package com.guru.cocktails.ui.cocktails.detail.di

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.CocktailsUseCase
import com.guru.cocktails.ui.cocktails.detail.CocktailDetailContract
import com.guru.cocktails.ui.cocktails.detail.CocktailDetailPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CocktailDetailModule(private val cocktailId: Int) {

    @ViewScope
    @Provides
    @Named("cocktailId")
    internal fun cocktailId(): Int {
        return cocktailId
    }

    @ViewScope
    @Provides
    internal fun ingredientPresenter(
        cocktailsUseCase: CocktailsUseCase,
        @Named("cocktailId") cocktailId: Int
    ): CocktailDetailContract.Presenter {
        return CocktailDetailPresenter(
            cocktailsUseCase = cocktailsUseCase,
            cocktailId = cocktailId
        )
    }
}
