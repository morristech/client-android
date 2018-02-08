package com.guru.cocktails.ui._remove.example2

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.GetWeatherRemotelyUseCase
import com.guru.cocktails.platform.extensions.getDisposableSingleObserver
import com.guru.cocktails.ui._remove.example2.Example2Contract.View
import com.guru.cocktails.ui.base.BasePresenterImpl
import com.guru.cocktails.ui.shared.ViewState
import javax.inject.Inject


@ViewScope
class Example2Presenter
@Inject
constructor(private val getWeatherRemotelyUseCase: GetWeatherRemotelyUseCase) : BasePresenterImpl(), Example2Contract.Presenter {

    var view: View? = null

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }

    override fun start() {
        super.start()
        refresh(CITY)
    }

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

    private fun setViewState(state: ViewState) {
        view?.viewState = state
    }

    companion object {
        val CITY = "London,uk"
    }
}