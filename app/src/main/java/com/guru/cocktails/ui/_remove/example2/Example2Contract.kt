package com.guru.cocktails.ui._remove.example2

import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView
import com.guru.cocktails.ui.shared.ViewState

interface Example2Contract {
    interface View : BaseView<Presenter> {
        override fun attachPresenter(presenter: Presenter)
        var viewState: ViewState
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun refresh(city: String)
    }
}