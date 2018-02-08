package com.guru.cocktails.ui._remove.example1.fragment

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.GetWeatherUseCase
import com.guru.cocktails.domain.model.Weather
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.base.BasePresenterImpl
import com.guru.cocktails.ui._remove.example1.fragment.Example1Contract.View
import dagger.internal.Preconditions.checkNotNull
import timber.log.Timber
import javax.inject.Inject

@ViewScope
class Example1Presenter
@Inject
constructor(
    private val getWeather: GetWeatherUseCase) : BasePresenterImpl(), Example1Contract.Presenter {

    private var view: View? = null

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }

    override fun start() {
        refresh()
    }

    override fun refresh() {
        val disposable = getWeather
            .execute("London,uk")
            .subscribeWith(getDisposableSubscriber({ onWeatherSuccess(it) }, { Timber.e(it) }))
        disposables.add(disposable)
    }

    private fun onWeatherSuccess(item: Weather) {
        view?.showWeather(item)
    }
}
