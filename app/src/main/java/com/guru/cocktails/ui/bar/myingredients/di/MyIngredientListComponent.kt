package com.guru.cocktails.ui.bar.myingredients.di

import com.guru.cocktails.di.component.ApplicationComponent
import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListFragment
import dagger.Component

@ViewScope
@Component(
    dependencies = [(ApplicationComponent::class)],
    modules = [(MyIngredientListModule::class)]
)
interface MyIngredientListComponent {
    fun inject(item: MyIngredientListFragment)
}