package com.guru.cocktails.ui.cocktails.cocktailslist

import com.guru.cocktails.ui.bar.ingredientlist.IngredientListAdapter
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface CocktailsListContract {
    interface View : BaseView<Presenter>, IngredientListAdapter.Callbacks {
        override fun attachPresenter(presenter: Presenter)
        var viewState: CocktailListViewState
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun subscribeToData()
        fun refresh()
    }
}
