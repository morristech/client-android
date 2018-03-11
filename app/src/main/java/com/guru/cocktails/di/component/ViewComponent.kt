package com.guru.cocktails.di.component

import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListFragment
import com.guru.cocktails.ui.base.BaseHolderFragment
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailListFragment
import dagger.Component

@ViewScope
@Component(
    dependencies = [(ApplicationComponent::class)],
    modules = [(PresenterModule::class)]
)
interface ViewComponent {

    fun inject(item: BaseHolderFragment)

    fun inject(item: IngredientListFragment)
    fun inject(item: CocktailListFragment)
}
