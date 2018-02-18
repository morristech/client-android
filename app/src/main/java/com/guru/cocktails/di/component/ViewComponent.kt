package com.guru.cocktails.di.component

import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui.academy.holder.AcademyHolderFragment
import com.guru.cocktails.ui.bar.holder.BarHolderFragment
import com.guru.cocktails.ui.bar.ingredients.IngredientsFragment
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderFragment
import com.guru.cocktails.ui.ingredient.IngredientActivity
import dagger.Component

@ViewScope
@Component(
    dependencies = arrayOf(
        ApplicationComponent::class
    ),
    modules = arrayOf(
        PresenterModule::class
    )
)
interface ViewComponent {

    fun inject(item: AcademyHolderFragment)
    fun inject(item: IngredientsFragment)
    fun inject(item: IngredientActivity)

    fun inject(item: CocktailsHolderFragment)
    fun inject(item: BarHolderFragment)
}
