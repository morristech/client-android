package com.guru.cocktails.ui.ingredientdetail

import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.GridLayoutManager
import android.transition.TransitionInflater
import android.view.View
import android.widget.Toast
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.domain.model.base.Mapper
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.domain.model.ingredient.IngredientDetail
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListAdapter
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui.description.DescriptionActivity
import com.guru.cocktails.ui.description.DescriptionViewModel
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailViewState.*
import kotlinx.android.synthetic.main.activity_ingredient.*
import timber.log.Timber
import javax.inject.Inject
import kotlin.properties.Delegates

class IngredientDetailActivity : BaseActivity(), IngredientDetailContract.View {


    @Inject lateinit var presenter: IngredientDetailContract.Presenter
    private var ingredientId: Int = -1
    private var ingredientDetail: IngredientDetail? = null

    override var detailViewState: IngredientDetailViewState by Delegates.observable<IngredientDetailViewState>(
        Init(), { _, _, new -> processStateChange(new) }
    )

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
        DaggerViewComponent.builder()
            .presenterModule(PresenterModule())
            .applicationComponent(App.instance.appComponent())
            .build()
            .inject(this)
    }

    override fun extractArguments() {
        intent?.let {
            ingredientId = it.getIntExtra(ARGS_INGREDIENT_ID, Mapper.INVALID_INT)
                .also {
                    if (it == Mapper.INVALID_INT) throw IllegalStateException("IngredientId was not passed in via Bundle")
                }
        }
    }

    override fun onViewsBound() {

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title = "White rum"

        val cocktails = listOf(
            IngredientThumb(1, "1", "1", "1", 1.0),
            IngredientThumb(1, "1", "1", "1", 1.0),
            IngredientThumb(1, "1", "1", "1", 1.0),
            IngredientThumb(1, "1", "1", "1", 1.0),
            IngredientThumb(1, "1", "1", "1", 1.0),
            IngredientThumb(1, "1", "1", "1", 1.0),
            IngredientThumb(1, "1", "1", "1", 1.0),
            IngredientThumb(1, "1", "1", "1", 1.0)
        )

        val manager = GridLayoutManager(this, 2)
        val adapterAbc = IngredientListAdapter(this, picasso)
        adapterAbc.updateData(cocktails)
        ai_rv.layoutManager = manager
        ai_rv.adapter = adapterAbc
        ai_rv.isNestedScrollingEnabled = false

        ai_ll_description.setOnClickListener { navigateToDescriptionDetail() }

        presenter.setIngredientType(ingredientId)
        presenter.start()
    }

    @Inject
    override fun attachPresenter(presenter: IngredientDetailContract.Presenter) {
        this.presenter.attachView(this)
    }

    private fun processStateChange(new: IngredientDetailViewState) {
        return when (new) {
            is Init            -> initialize()
            is Loading         -> loading()
            is Success         -> onNewItem(new.item)
            is Error           -> onError(new.error)
            is LoadingFinished -> finishLoading()
        }
    }

    private fun initialize() {
    }

    private fun loading() {
    }

    private fun finishLoading() {
    }

    private fun onNewItem(item: IngredientDetail) {
        ingredientDetail = item
        picasso.load(item.imageUrl).into(image)
        collapsing_toolbar.title = item.name
        place_detail.text = item.description
    }

    private fun onError(e: Throwable) {
        finish()
        Toast.makeText(this, """Error :$e""", Toast.LENGTH_LONG).show()
    }

    override fun onClick(item: IngredientThumb, sharedElements: List<Pair<View, String>>?) {

    }

    private fun navigateToDescriptionDetail() {
        ingredientDetail?.let {
            val pairs = listOf(
                Pair(place_detail as View, "description"),
                Pair(image as View, "image")
            )
            val bundle = DescriptionActivity.newBundle(
                DescriptionViewModel(
                    it.name,
                    it.description,
                    it.imageUrl
                )
            )
            navigator.navigate(this, DescriptionActivity::class.java, bundle, pairs)
        } ?: Timber.e(IllegalStateException("Ingredient with id : $ingredientId was null"))
    }

    companion object {

        fun createBundle(ingredientId: Int): Bundle = Bundle().apply {
            putInt(ARGS_INGREDIENT_ID, ingredientId)
        }

        private const val ARGS_INGREDIENT_ID = "ARGS_INGREDIENT_ID"
    }
}
