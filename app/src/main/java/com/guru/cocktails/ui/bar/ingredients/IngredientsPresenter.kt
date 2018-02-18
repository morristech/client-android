package com.guru.cocktails.ui.bar.ingredients

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.bar.ingredients.IngredientsContract.View
import com.guru.cocktails.ui.bar.ingredients.IngredientsViewState.*
import com.guru.cocktails.ui.base.BasePresenterImpl
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

        val flowable = when (type) {
            is Type.Alcoholic -> ingredientsUseCase.getAllAlcoholicIngredients()
            is Type.NonAlcoholic -> ingredientsUseCase.getAllNonAlcoholicIngredients()
        }

        val disposable = flowable
            .doOnSubscribe { setViewState(Loading()) }
            .doFinally { setViewState(LoadingFinished()) }
            .subscribeWith(
                getDisposableSubscriber(
                    { setViewState(Success(it)) },
                    { setViewState(Error(it)) })
            )
        disposables.add(disposable)
    }

    private fun setViewState(state: IngredientsViewState) {
        view?.viewState = state
    }
}