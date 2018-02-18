package com.guru.cocktails.ui.ingredient

import com.guru.cocktails.ui.bar.ingredients.IngredientsAdapter
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface IngredientContract {
    interface View : BaseView<Presenter>, IngredientsAdapter.Callbacks {
        override fun attachPresenter(presenter: Presenter)
        var viewState: IngredientViewState
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun setIngredientType(ingredientId: Int)
        fun load()
    }
}