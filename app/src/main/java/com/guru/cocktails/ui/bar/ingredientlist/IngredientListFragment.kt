package com.guru.cocktails.ui.bar.ingredientlist

import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.platform.extensions.ifAdded
import com.guru.cocktails.platform.extensions.lazyFast
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListContract.Presenter

import com.guru.cocktails.ui.base.BaseFragment
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailActivity
import kotlinx.android.synthetic.main.recycler_view.*
import javax.inject.Inject


class IngredientListFragment : BaseFragment(), IngredientListContract.View {

    private lateinit var type: Type
    private var presenter: Presenter? = null
    private val adapter by lazyFast { IngredientListAdapter(this, picasso) }

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

    override fun extractArguments() {
        arguments?.let {
            it.getString(ARGS_TYPE)?.let {
                type = when (it) {
                    TYPE_ALCOHOLIC     -> Type.Alcoholic()
                    TYPE_NON_ALCOHOLIC -> Type.NonAlcoholic()
                    else               -> throw IllegalStateException("Unknown type passed via bundle : $it")
                }
            } ?: throw IllegalStateException("Type was not passed in vai Bundle")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_rv.adapter = adapter
        rv_rv.layoutManager = GridLayoutManager(activity, 2)
        rv_srl.setOnRefreshListener { presenter?.refresh() }

        presenter?.setIngredientType(type)
        presenter?.start()
    }

    override fun onDestroy() {
        presenter?.stop()
        super.onDestroy()
    }

    override fun onClick(item: IngredientThumb, sharedElements: List<Pair<View, String>>?) {
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

    override fun startLoading() {
        rv_srl.isRefreshing = true
    }

    override fun stopLoading() {
        rv_srl.isRefreshing = false
    }

    override fun onNewData(list: List<IngredientThumb>) {
        adapter.updateData(list)
    }

    override fun onError(error: Throwable) {
        ifAdded { Toast.makeText(activity, """Error :$error""", Toast.LENGTH_LONG).show() }
    }

    companion object {

        fun newInstance(bundle: Bundle) = IngredientListFragment().apply {
            arguments = bundle
        }

        fun createBundle(type: Type) = Bundle().apply {

            val typeString = when (type) {
                is Type.Alcoholic    -> TYPE_ALCOHOLIC
                is Type.NonAlcoholic -> TYPE_NON_ALCOHOLIC
            }

            putString(ARGS_TYPE, typeString)
        }

        private const val TYPE_ALCOHOLIC = "TYPE_ALCOHOLIC"
        private const val TYPE_NON_ALCOHOLIC = "TYPE_NON_ALCOHOLIC"

        private const val ARGS_TYPE = "ARGS_TYPE"
    }
}