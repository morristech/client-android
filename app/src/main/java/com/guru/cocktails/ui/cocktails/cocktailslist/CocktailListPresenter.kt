package com.guru.cocktails.ui.cocktails.cocktailslist

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.CocktailsUseCase
import com.guru.cocktails.platform.extensions.getDisposableCompletableObserver
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.base.BasePresenterImpl
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailListViewState.*
import timber.log.Timber
import javax.inject.Inject

@ViewScope
class CocktailListPresenter
@Inject constructor(
    private val cocktailsUseCase: CocktailsUseCase
) : BasePresenterImpl(), CocktailsListContract.Presenter {

    private var view: CocktailsListContract.View? = null

    override fun attachView(view: CocktailsListContract.View) {
        this.view = checkNotNull(view)
    }

    override fun start() {
        super.start()
        subscribeToData()
        refresh()
    }

    override fun subscribeToData() {
        cocktailsUseCase.getCocktailsList()
            .subscribeWith(getDisposableSubscriber({ setViewState(Success(it)) }, { setViewState(Error(it)) }))
            .also { disposables.add(it) }
    }

    override fun refresh() {
        cocktailsUseCase
            .refreshCocktailsList()
            .doOnSubscribe { setViewState(Loading()) }
            .doFinally { setViewState(LoadingFinished()) }
            .subscribeWith(getDisposableCompletableObserver({ Timber.i("Refresh sucessfull") }))
            .also { disposables.add(it) }
    }

    private fun setViewState(state: CocktailListViewState) {
        view?.viewState = state
    }
}