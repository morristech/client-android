package com.guru.cocktails.ui.bar.myingredients

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.MyIngredientsUseCase
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListContract.View
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListType.MyBar
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListType.ShoppingList
import com.guru.cocktails.ui.base.BasePresenterImpl
import javax.inject.Inject

@ViewScope
class MyIngredientListPresenter
@Inject constructor(
    private val myIngredientsUseCase: MyIngredientsUseCase,
    private val myIngredientListType: MyIngredientListType
) : BasePresenterImpl(), MyIngredientListContract.Presenter {

    private var view: View? = null

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }

    override fun start() {
        super.start()
        subscribeToData()
    }

    private fun subscribeToData() {

        val flowable = when (myIngredientListType) {
            is MyBar        -> myIngredientsUseCase.getMyIngredients()
            is ShoppingList -> myIngredientsUseCase.getShoppingListIngredients()
        }

        flowable
            .subscribeWith(getDisposableSubscriber({ view?.onNewData(it) }, { view?.onError(it) }))
            .also { disposables.add(it) }
    }

}