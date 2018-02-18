package com.guru.cocktails.ui.academy.holder

import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface AcademyHolderContract {
    interface View : BaseView<Presenter> {
        override fun attachPresenter(presenter: Presenter)
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
    }
}
