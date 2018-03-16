package com.guru.cocktails.ui.cocktails.detail

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.CocktailsUseCase
import com.guru.cocktails.platform.extensions.getDisposableCompletableObserver
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.base.BasePresenterImpl
import com.guru.cocktails.ui.cocktails.detail.CocktailDetailContract.View
import timber.log.Timber
import javax.inject.Inject

@ViewScope
class CocktailDetailPresenter
@Inject constructor(
    private val cocktailsUseCase: CocktailsUseCase,
    private val cocktailId: Int
) : BasePresenterImpl(), CocktailDetailContract.Presenter {

    private var view: View? = null

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }

    override fun start() {
        super.start()
        subscribeToData()
        refresh()
    }

    override fun refresh() {
        cocktailsUseCase
            .refreshCocktailDetail(cocktailId)
            .doOnSubscribe { view?.startLoading() }
            .doFinally { view?.startLoading() }
            .subscribeWith(getDisposableCompletableObserver({ Timber.i("Refresh sucessfull") }))
            .also { disposables.add(it) }
    }

    private fun subscribeToData() {
        cocktailsUseCase
            .getCocktailDetail(cocktailId)
            .subscribeWith(getDisposableSubscriber({ view?.onNewData(it) }, { view?.onError(it) }))
            .also { disposables.add(it) }
    }

}