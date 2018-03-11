package com.guru.cocktails.ui.ingredientdetail

import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.model.ingredient.MyIngredient
import com.guru.cocktails.ui.base.BaseDataView
import com.guru.cocktails.ui.base.BaseListAdapter
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface IngredientDetailContract {
    interface View : BaseView<Presenter>, BaseDataView<IngredientDetail>, BaseListAdapter.Callbacks<IngredientThumb> {
        override fun attachPresenter(presenter: Presenter)
        fun myIngredientUpdated(item: MyIngredient)
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun refresh()
        fun addToMyBar()
        fun removeFromMyBar()
        fun addToShoppingList()
        fun removeFromShoppingList()
    }
}