package com.guru.cocktails.ui.cocktails.cocktailslist

import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import com.guru.cocktails.ui.base.BaseListAdapter
import com.guru.cocktails.ui.base.BaseListView
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface CocktailsListContract {
    interface View : BaseView<Presenter>, BaseListView<CocktailThumb>, BaseListAdapter.Callbacks<CocktailThumb> {
        override fun attachPresenter(presenter: Presenter)
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun refresh()
    }
}
