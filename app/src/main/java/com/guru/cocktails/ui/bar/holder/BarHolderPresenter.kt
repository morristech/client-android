package com.guru.cocktails.ui.bar.holder

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui.bar.holder.BarHolderContract.View
import com.guru.cocktails.ui.base.BasePresenterImpl
import javax.inject.Inject


@ViewScope
class BarHolderPresenter
@Inject constructor(

) : BasePresenterImpl(), BarHolderContract.Presenter {

    var view: View? = null

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }
}