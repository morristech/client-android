package com.guru.cocktails.ui.academy.holder

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.ui.base.BasePresenterImpl
import com.guru.cocktails.ui.academy.holder.AcademyHolderContract.View
import javax.inject.Inject


@ViewScope
class AcademyHolderPresenter
@Inject constructor(
    private val ingredientsUseCase: IngredientsUseCase
) : BasePresenterImpl(), AcademyHolderContract.Presenter {

    var view: View? = null

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }



/*

    override fun refresh(city: String) {
        val disposable = getWeatherRemotelyUseCase
            .execute(city)
            .doOnSubscribe { setViewState(ViewState.Loading()) }
            .doFinally { setViewState(ViewState.LoadingFinished()) }
            .subscribeWith(
                getDisposableSingleObserver(
                    { setViewState(ViewState.Success(it)) },
                    { setViewState(ViewState.Error(it)) })
            )
        disposables.add(disposable)
    }
*/
/*
    private fun setViewState(state: ViewState) {
        view?.viewState = state
    }*/

}