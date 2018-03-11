package com.guru.cocktails.ui.bar.ingredientlist.di

import com.guru.cocktails.di.component.ApplicationComponent
import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListFragment
import dagger.Component

@ViewScope
@Component(
    dependencies = [(ApplicationComponent::class)],
    modules = [(IngredientListModule::class)]
)
interface IngredientListComponent {
    fun inject(item: IngredientListFragment)
}