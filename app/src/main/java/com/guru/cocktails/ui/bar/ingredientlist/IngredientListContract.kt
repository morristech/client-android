package com.guru.cocktails.ui.bar.ingredientlist

import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.ui.base.BaseListAdapter
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface IngredientListContract {
    interface View : BaseView<Presenter>, BaseListAdapter.Callbacks<IngredientThumb> {
        override fun attachPresenter(presenter: Presenter)
        var viewState: IngredientListViewState
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun setIngredientType(type: Type)
        fun subscribeToData()
        fun refresh()
    }
}
