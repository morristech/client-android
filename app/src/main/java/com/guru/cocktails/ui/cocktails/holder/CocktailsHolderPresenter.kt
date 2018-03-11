package com.guru.cocktails.ui.cocktails.holder

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui.base.BasePresenterImpl
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderContract.View
import javax.inject.Inject


@ViewScope
class CocktailsHolderPresenter
@Inject constructor(
) : BasePresenterImpl(), CocktailsHolderContract.Presenter {

    var view: View? = null

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }
}