package com.guru.cocktails.ui.bar.ingredientlist

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.platform.extensions.getDisposableCompletableObserver
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListContract.View
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListViewState.Error
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListViewState.Success
import com.guru.cocktails.ui.base.BasePresenterImpl
import timber.log.Timber
import javax.inject.Inject

@ViewScope
class IngredientListPresenter
@Inject constructor(
    private val ingredientsUseCase: IngredientsUseCase
) : BasePresenterImpl(), IngredientListContract.Presenter {

    private var view: View? = null
    private lateinit var type: Type

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }

    override fun start() {
        super.start()
        subscribeToData()
        refresh()
    }

    override fun setIngredientType(type: Type) {
        this.type = type
    }

    override fun subscribeToData() {

        val flowable = when (type) {
            is Type.Alcoholic    -> ingredientsUseCase.getAllAlcoholicIngredients()
            is Type.NonAlcoholic -> ingredientsUseCase.getAllNonAlcoholicIngredients()
        }

        flowable
            .subscribeWith(getDisposableSubscriber({ setViewState(Success(it)) }, { setViewState(Error(it)) }))
            .also { disposables.add(it) }
    }

    //TODO check if internet connection is present?
    override fun refresh() {

        val completable = when (type) {
            is Type.Alcoholic    -> ingredientsUseCase.refreshAllAlcoholicIngredients()
            is Type.NonAlcoholic -> ingredientsUseCase.refreshAllNonAlcoholicIngredients()
        }

        completable
            .doOnSubscribe { setViewState(IngredientListViewState.Loading()) }
            .doFinally { setViewState(IngredientListViewState.LoadingFinished()) }
            .subscribeWith(getDisposableCompletableObserver({ Timber.i("Refresh sucessfull") }))
            .also { disposables.add(it) }
    }

    private fun setViewState(state: IngredientListViewState) {
        Timber.e(state.toString())
        view?.viewState = state
    }
}