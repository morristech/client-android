package com.guru.cocktails.ui._remove.example1.fragment

import com.guru.cocktails.domain.model.Weather
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface Example1Contract {
    interface View : BaseView<Presenter> {
        override fun attachPresenter(presenter: Presenter)
        fun showWeather(data: Weather)
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun refresh()
    }
}
