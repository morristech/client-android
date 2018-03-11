package com.guru.cocktails.ui.cocktails.cocktailslist

import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import com.guru.cocktails.platform.extensions.ifAdded
import com.guru.cocktails.platform.extensions.lazyFast
import com.guru.cocktails.ui.base.BaseFragment
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailListViewState.*
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailsListContract.Presenter
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailActivity
import kotlinx.android.synthetic.main.recycler_view.*
import javax.inject.Inject
import kotlin.properties.Delegates


class CocktailListFragment : BaseFragment(), CocktailsListContract.View {

    private var presenter: Presenter? = null
    private val adapter by lazyFast { CocktailListAdapter(this, picasso) }

    override var viewState: CocktailListViewState by Delegates.observable<CocktailListViewState>(
        Init(), { _, _, new -> processStateChange(new) })

    override fun layoutId() = R.layout.recycler_view

    override fun initializeDependencies() {
        DaggerViewComponent.builder()
            .applicationComponent(App.instance.appComponent())
            .presenterModule(PresenterModule())
            .build()
            .inject(this)
    }

    @Inject
    override fun attachPresenter(presenter: Presenter) {
        this.presenter = presenter
        this.presenter?.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_rv.adapter = adapter
        rv_rv.layoutManager = GridLayoutManager(activity, 2)
        rv_srl.setOnRefreshListener { presenter?.refresh() }

        presenter?.start()
    }

    override fun onDestroy() {
        presenter?.stop()
        super.onDestroy()
    }

    override fun onClick(item: CocktailThumb, sharedElements: List<Pair<View, String>>?) {
        ifAdded { abc ->
            //TODO picasso.subscribeToData(item.imageUrl).fetch() prefetch large image
            navigator.navigate(
                source = abc,
                target = IngredientDetailActivity::class.java,
                //    sharedElements = sharedElements,
                bundle = IngredientDetailActivity.createBundle(item.id)
            )
        }
    }

    private fun processStateChange(new: CocktailListViewState) {
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
        rv_srl.isRefreshing = true
    }

    private fun finishLoading() {
        rv_srl.isRefreshing = false
    }

    private fun onNewItem(data: List<CocktailThumb>) {
        adapter.updateData(data)
    }

    private fun onError(e: Throwable) {
        ifAdded { Toast.makeText(activity, """Error :$e""", Toast.LENGTH_LONG).show() }
    }

    companion object {

        fun newInstance() = CocktailListFragment().apply {
        }

        fun createBundle() = Bundle().apply {
        }

    }
}