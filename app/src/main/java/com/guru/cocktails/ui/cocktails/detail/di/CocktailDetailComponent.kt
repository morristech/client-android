package com.guru.cocktails.ui.cocktails.detail.di

import com.guru.cocktails.di.component.ApplicationComponent
import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui.cocktails.detail.CocktailDetailActivity
import dagger.Component

@ViewScope
@Component(
    dependencies = [(ApplicationComponent::class)],
    modules = [(CocktailDetailModule::class)]
)
interface CocktailDetailComponent {
    fun inject(item: CocktailDetailActivity)
}
