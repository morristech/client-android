package com.guru.cocktails.ui.cocktails.detail

import android.os.Bundle
import android.transition.TransitionInflater
import android.widget.Toast
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.domain.model.cocktail.CocktailDetailBundle
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui.cocktails.detail.CocktailDetailContract.Presenter
import com.guru.cocktails.ui.cocktails.detail.di.CocktailDetailModule
import com.guru.cocktails.ui.cocktails.detail.di.DaggerCocktailDetailComponent
import kotlinx.android.synthetic.main.activity_ingredient.*
import timber.log.Timber
import javax.inject.Inject

class CocktailDetailActivity : BaseActivity(), CocktailDetailContract.View {

    @Inject lateinit var presenter: Presenter
    private var cocktailId: Int = -1

    override fun layoutId() = R.layout.activity_ingredient

    override fun onCreate(savedInstanceState: Bundle?) {
        window.enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        presenter.stop()
        super.onDestroy()
    }

    override fun inject() {
        DaggerCocktailDetailComponent.builder()
            .cocktailDetailModule(CocktailDetailModule(cocktailId))
            .applicationComponent(App.instance.appComponent())
            .build()
            .inject(this)
    }

    @Inject
    override fun attachPresenter(presenter: Presenter) {
        this.presenter.attachView(this)
    }

    override fun extractArguments() {
        intent?.let {
            cocktailId = it.getIntExtra(ARG_COCKTAIL_ID, Mapper.INVALID_INT)
                .also {
                    if (it == Mapper.INVALID_INT) throw IllegalStateException("CocktailId was not passed in via Bundle")
                }
        }
    }

    override fun onViewsBound() {

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title = "White rum"

        presenter.start()
    }

    override fun startLoading() {
    }

    override fun stopLoading() {
    }

    override fun onNewData(item: CocktailDetailBundle) {
        Timber.e(item.toString())
    }

    override fun onError(error: Throwable) {
        finish()
        Toast.makeText(this, """Error :$error""", Toast.LENGTH_LONG).show()
    }


    companion object {

        fun createBundle(ingredientId: Int): Bundle = Bundle().apply {
            putInt(ARG_COCKTAIL_ID, ingredientId)
        }

        private const val ARG_COCKTAIL_ID = "ARGS_COCKTAIL_ID"
    }
}
