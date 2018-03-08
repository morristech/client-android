package com.guru.cocktails.ui.ingredientdetail

import com.guru.cocktails.data.mapper.base.Mapper
import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.base.BasePresenterImpl
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailContract.View
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailViewState.*
import javax.inject.Inject


@ViewScope
class IngredientDetailPresenter @Inject constructor(
    private val ingredientsUseCase: IngredientsUseCase
) : BasePresenterImpl(), IngredientDetailContract.Presenter {

    private var view: View? = null
    private var ingredientId: Int = Mapper.INVALID_INT

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }

    override fun setIngredientType(ingredientId: Int) {
        this.ingredientId = ingredientId
    }

    override fun load() {

        val disposable = ingredientsUseCase
            .getIngredientDetail(ingredientId)
            .doOnSubscribe { setViewState(Loading()) }
            .doFinally { setViewState(LoadingFinished()) }
            .subscribeWith(
                getDisposableSubscriber(
                    { setViewState(Success(it)) },
                    { setViewState(Error(it)) }
                )
            )
        disposables.add(disposable)
    }

    private fun setViewState(stateDetail: IngredientDetailViewState) {
        view?.detailViewState = stateDetail
    }
}