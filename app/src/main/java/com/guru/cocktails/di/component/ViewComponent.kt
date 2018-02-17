package com.guru.cocktails.di.component

import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui._remove.example1.Example1Activity
import com.guru.cocktails.ui._remove.example1.fragment.Example1Fragment
import com.guru.cocktails.ui._remove.example2.Example2Activity
import com.guru.cocktails.ui._remove.example3.Example3Activity
import com.guru.cocktails.ui._remove.example3.fragment.Example3Fragment
import com.guru.cocktails.ui._remove.main.MainActivity
import com.guru.cocktails.ui.bar.holder.BarHolderFragment
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderFragment
import com.guru.cocktails.ui.ingredient.IngredientActivity
import com.guru.cocktails.ui.ingredients.IngredientsFragment
import com.guru.cocktails.ui.ingredients.holder.IngredientsHolderFragment
import dagger.Component

@ViewScope
@Component(dependencies = arrayOf(
    ApplicationComponent::class),
    modules = arrayOf(PresenterModule::class))
interface ViewComponent {

    fun inject(item: MainActivity)

    fun inject(item: Example1Activity)
    fun inject(item: Example1Fragment)

    fun inject(item: Example2Activity)

    fun inject(item: Example3Fragment)
    fun inject(item: Example3Activity)

    fun inject(item: IngredientsHolderFragment)
    fun inject(item: IngredientsFragment)
    fun inject(item: IngredientActivity)

    fun inject(item: CocktailsHolderFragment)
    fun inject(item: BarHolderFragment)
}
