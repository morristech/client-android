package com.guru.cocktails.ui.ingredients

import android.os.Bundle
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.platform.extensions.getDisposableSubscriber
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui.ingredient.IngredientActivity
import com.guru.cocktails.ui.shared.DrawerItems
import com.guru.cocktails.ui.shared.DrawerManager
import kotlinx.android.synthetic.main.activity_ingredients.*
import timber.log.Timber
import javax.inject.Inject


class IngredientsActivity : BaseActivity() {

    @Inject lateinit var ingredientsUseCase: IngredientsUseCase
    private lateinit var drawerManager: DrawerManager

    override fun inject() {
        App.instance.appComponent().inject(this)
    }

    override fun layoutId(): Int {
        return R.layout.activity_ingredients
    }

    override fun afterLayout(savedInstanceState: Bundle?) {
        super.afterLayout(savedInstanceState)
        drawerManager = DrawerManager(this, DrawerItems.Ingredients())


        val disposable = ingredientsUseCase
            .getNonAlcoList()
            .subscribeWith(getDisposableSubscriber({ Timber.e(it.toString()) }))

        disposables.add(disposable)

        ai_btn_click_me.setOnClickListener{
            navigator.navigate(this,IngredientActivity::class.java)
        }
    }
}