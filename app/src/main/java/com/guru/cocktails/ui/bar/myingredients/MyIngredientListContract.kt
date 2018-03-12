package com.guru.cocktails.ui.bar.myingredients

import com.guru.cocktails.domain.model.ingredient.MyIngredient
import com.guru.cocktails.ui.base.BaseListAdapter
import com.guru.cocktails.ui.base.BaseListView
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface MyIngredientListContract {
    interface View : BaseView<Presenter>, BaseListView<MyIngredient>, BaseListAdapter.Callbacks<MyIngredient> {
        override fun attachPresenter(presenter: Presenter)
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
    }
}
