package com.guru.cocktails.ui.cocktails.detail

import com.guru.cocktails.domain.model.cocktail.CocktailDetailBundle
import com.guru.cocktails.ui.base.BaseDataView
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface CocktailDetailContract {
    interface View : BaseView<Presenter>, BaseDataView<CocktailDetailBundle> {
        override fun attachPresenter(presenter: Presenter)
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun refresh()
    }
}