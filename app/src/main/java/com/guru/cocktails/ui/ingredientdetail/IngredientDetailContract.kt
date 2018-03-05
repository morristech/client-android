package com.guru.cocktails.ui.ingredientdetail

import com.guru.cocktails.ui.bar.ingredientlist.IngredientListAdapter
import com.guru.cocktails.ui.base.BasePresenter
import com.guru.cocktails.ui.base.BaseView

interface IngredientDetailContract {
    interface View : BaseView<Presenter>, IngredientListAdapter.Callbacks {
        override fun attachPresenter(presenter: Presenter)
        var detailViewState: IngredientDetailViewState
        fun setTitle(djksbadfjsa:String)
    }

    interface Presenter : BasePresenter<View> {
        override fun attachView(view: View)
        fun setIngredientType(ingredientId: Int)
        fun load()
    }
}