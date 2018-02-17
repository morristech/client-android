package com.guru.cocktails.ui.ingredients

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.base.BasePresenterImpl
import com.guru.cocktails.ui.ingredients.IngredientsContract.View
import javax.inject.Inject


@ViewScope
class IngredientsPresenter
@Inject constructor(
    private val ingredientsUseCase: IngredientsUseCase
) : BasePresenterImpl(), IngredientsContract.Presenter {

    private var view: View? = null
    private lateinit var type: Type

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }

    override fun start() {
        super.start()
        load()
    }

    override fun setIngredientType(type: Type) {
        this.type = type
    }

    override fun load() {
        val disposable = ingredientsUseCase
            .getNonAlcoList()
            .doOnSubscribe { setViewState(IngredientsViewState.Loading()) }
            .doFinally { setViewState(IngredientsViewState.LoadingFinished()) }
            .subscribeWith(
                getDisposableSubscriber(
                    { setViewState(IngredientsViewState.Success(it)) },
                    { setViewState(IngredientsViewState.Error(it)) })
            )
        disposables.add(disposable)
    }

    private fun setViewState(state: IngredientsViewState) {
        view?.viewState = state
    }
}