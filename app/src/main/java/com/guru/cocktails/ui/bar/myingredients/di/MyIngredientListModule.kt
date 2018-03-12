package com.guru.cocktails.ui.bar.myingredients.di

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.MyIngredientsUseCase
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListContract
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListPresenter
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListType
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MyIngredientListModule(private val type: MyIngredientListType) {

    @ViewScope
    @Provides
    @Named("myIngredientListType")
    internal fun myIngredientListType(): MyIngredientListType {
        return type
    }

    @ViewScope
    @Provides
    internal fun ingredientsPresenter(
        myIngredientsUseCase: MyIngredientsUseCase,
        @Named("myIngredientListType") myIngredientListType: MyIngredientListType
    ): MyIngredientListContract.Presenter {
        return MyIngredientListPresenter(myIngredientsUseCase, myIngredientListType)
    }
}