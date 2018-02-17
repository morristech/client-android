package com.guru.cocktails.ui.ingredients

import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface IngredientsContract {
    interface View : BaseView<Presenter>, IngredientsAdapter.Callbacks {
        override fun attachPresenter(presenter: Presenter)
        var viewState: IngredientsViewState
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun setIngredientType(type: Type)
        fun load()
    }
}
