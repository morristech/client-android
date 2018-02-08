package com.guru.cocktails.ui.ingredient

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui.ingredient.IngredientContract.View
import javax.inject.Inject


@ViewScope
class IngredientPresenter
@Inject
constructor() : IngredientContract.Presenter {

    private var view: View? = null

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }

    override fun start() {
    }

    override fun stop() {
    }
}