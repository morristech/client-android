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
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailsListContract.Presenter
import com.guru.cocktails.ui.cocktails.detail.CocktailDetailActivity
import kotlinx.android.synthetic.main.recycler_view.*
import javax.inject.Inject


class CocktailListFragment : BaseFragment(), CocktailsListContract.View {

    private var presenter: Presenter? = null
    private val adapter by lazyFast { CocktailListAdapter(this, picasso) }

    override fun layoutId() = R.layout.recycler_view

    override fun inject() {
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
                target = CocktailDetailActivity::class.java,
                //    sharedElements = sharedElements,
                bundle = CocktailDetailActivity.createBundle(item.id)
            )
        }
    }

    override fun startLoading() {
        ifAdded { rv_srl?.isRefreshing = true }
    }

    override fun stopLoading() {
        ifAdded { rv_srl?.isRefreshing = false }
    }

    override fun onNewData(list: List<CocktailThumb>) {
        ifAdded { adapter.updateData(list) }
    }

    override fun onError(error: Throwable) {
        ifAdded { Toast.makeText(activity, """Error :$error""", Toast.LENGTH_LONG).show() }
    }

    companion object {

        fun newInstance() = CocktailListFragment().apply {
        }

        fun createBundle() = Bundle().apply {
        }

    }
}