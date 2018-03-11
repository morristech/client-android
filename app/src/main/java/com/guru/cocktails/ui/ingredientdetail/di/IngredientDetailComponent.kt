package com.guru.cocktails.ui.ingredientdetail.di

import com.guru.cocktails.di.component.ApplicationComponent
import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailActivity
import dagger.Component

@ViewScope
@Component(
    dependencies = [(ApplicationComponent::class)],
    modules = [(IngredientDetailModule::class)]
)
interface IngredientDetailComponent {
    fun inject(item: IngredientDetailActivity)
}
