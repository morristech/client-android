package com.guru.cocktails.ui.bar.ingredientlist

import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.ui.base.BaseListAdapter
import com.guru.cocktails.ui.base.BaseListView
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface IngredientListContract {
    interface View : BaseView<Presenter>, BaseListView<IngredientThumb>, BaseListAdapter.Callbacks<IngredientThumb> {
        override fun attachPresenter(presenter: Presenter)
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun refresh()
    }
}
