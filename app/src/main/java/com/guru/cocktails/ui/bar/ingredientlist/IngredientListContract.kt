package com.guru.cocktails.ui.bar.ingredientlist

import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface IngredientListContract {
    interface View : BaseView<Presenter>, IngredientListAdapter.Callbacks {
        override fun attachPresenter(presenter: Presenter)
        var viewState: IngredientListViewState
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun setIngredientType(type: Type)
        fun load()
    }
}
