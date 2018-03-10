package com.guru.cocktails.ui.cocktails.cocktailslist

import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.ui.base.BaseListAdapter
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface CocktailsListContract {
    interface View : BaseView<Presenter>, BaseListAdapter.Callbacks<CocktailThumb> {
        override fun attachPresenter(presenter: Presenter)
        var viewState: CocktailListViewState
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun subscribeToData()
        fun refresh()
    }
}
