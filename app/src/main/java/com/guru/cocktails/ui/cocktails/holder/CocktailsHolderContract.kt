package com.guru.cocktails.ui.cocktails.holder

import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface CocktailsHolderContract {
    interface View : BaseView<Presenter> {
        override fun attachPresenter(presenter: Presenter)
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
    }
}
