package com.guru.cocktails.ui.ingredientdetail

import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.ui.base.BaseListAdapter
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface IngredientDetailContract {
    interface View : BaseView<Presenter>, BaseListAdapter.Callbacks<IngredientThumb> {
        override fun attachPresenter(presenter: Presenter)
        var detailViewState: IngredientDetailViewState
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun setIngredientType(ingredientId: Int)
        fun refresh()
        fun addToMyBar()
        fun removeFromMyBar()
        fun addToShoppingList()
        fun removeFromShoppingList()
    }
}