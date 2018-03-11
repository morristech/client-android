package com.guru.cocktails.ui.ingredientdetail

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.domain.interactor.definition.MyIngredientsUseCase
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.MyIngredient
import com.guru.cocktails.domain.model.mapper.MyIngredientMapper
import com.guru.cocktails.platform.extensions.getDisposableCompletableObserver
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.base.BasePresenterImpl
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailContract.View
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailViewState.*
import timber.log.Timber
import javax.inject.Inject

@ViewScope
class IngredientDetailPresenter
@Inject constructor(
    private val ingredientsUseCase: IngredientsUseCase,
    private val myIngredientsUseCase: MyIngredientsUseCase,
    private val myIngredientMapper: MyIngredientMapper,
    private val ingredientId: Int
) : BasePresenterImpl(), IngredientDetailContract.Presenter {

    private var view: View? = null
    private var ingredient: IngredientDetail? = null
    private var myIngredient: MyIngredient? = null

    override fun attachView(view: View) {
        this.view = checkNotNull(view)
    }

    override fun start() {
        super.start()
        subscribeToData()
        refresh()
    }

    override fun refresh() {
        ingredientsUseCase
            .refreshIngredientDetail(ingredientId)
            .doOnSubscribe { setViewState(Loading()) }
            .doFinally { setViewState(LoadingFinished()) }
            .subscribeWith(getDisposableCompletableObserver({ Timber.i("Refresh sucessfull") }))
            .also { disposables.add(it) }
    }

    override fun addToMyBar() {
        myIngredient = getMyIngredient()
            .copy(myBar = true)
            .also {
                myIngredientsUseCase
                    .addToMyBar(it)
                    .subscribeWith(getDisposableCompletableObserver({ Timber.i("addToMyBar sucessfull") }))
                    .also { disposables.add(it) }
            }
    }

    override fun removeFromMyBar() {
        myIngredient = getMyIngredient()
            .copy(myBar = false)
            .also {
                myIngredientsUseCase
                    .removeFromMyBar(it)
                    .subscribeWith(getDisposableCompletableObserver({ Timber.i("removeFromMyBar sucessfull") }))
                    .also { disposables.add(it) }
            }
    }

    override fun addToShoppingList() {
        myIngredient = getMyIngredient()
            .copy(shoppingCart = true)
            .also {
                myIngredientsUseCase
                    .addToShoppingList(it)
                    .subscribeWith(getDisposableCompletableObserver({ Timber.i("addToShoppingList sucessfull") }))
                    .also { disposables.add(it) }
            }
    }

    override fun removeFromShoppingList() {
        myIngredient = getMyIngredient()
            .copy(shoppingCart = false)
            .also {
                myIngredientsUseCase
                    .removeFromShoppingList(it)
                    .subscribeWith(getDisposableCompletableObserver({ Timber.i("removeFromShoppingList sucessfull") }))
                    .also { disposables.add(it) }
            }
    }

    private fun subscribeToData() {
        ingredientsUseCase
            .getIngredientDetail(ingredientId)
            .subscribeWith(getDisposableSubscriber({ ingredient = it; setViewState(Success(it)) }, { setViewState(Error(it)) }))
            .also { disposables.add(it) }

        myIngredientsUseCase
            .getMyIngredientById(ingredientId)
            .subscribeWith(getDisposableSubscriber({ myIngredient = it;setViewState(MyIngredientUpdate(it)) }, { /* Do we care ???*/ }))
            .also { disposables.add(it) }
    }

    private fun setViewState(stateDetail: IngredientDetailViewState) {
        view?.detailViewState = stateDetail
    }

    //todo rewrite (custom getter??)
    private fun getMyIngredient(): MyIngredient {
        return if (ingredient == null) {
            throw IllegalStateException("Ingredient is null")
        } else {
            if (myIngredient == null) {
                myIngredient = myIngredientMapper.map(ingredient!!)
                myIngredient!!
            } else {
                myIngredient!!
            }
        }
    }
}