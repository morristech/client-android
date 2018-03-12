package com.guru.cocktails.ui.bar.myingredients

import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.domain.model.ingredient.MyIngredient
import com.guru.cocktails.platform.extensions.ifAdded
import com.guru.cocktails.platform.extensions.lazyFast
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListContract.Presenter
import com.guru.cocktails.ui.bar.myingredients.di.DaggerMyIngredientListComponent
import com.guru.cocktails.ui.bar.myingredients.di.MyIngredientListModule
import com.guru.cocktails.ui.base.BaseFragment
import com.guru.cocktails.ui.ingredientdetail.IngredientDetailActivity
import kotlinx.android.synthetic.main.recycler_view.*
import javax.inject.Inject


class MyIngredientListFragment : BaseFragment(), MyIngredientListContract.View {

    private lateinit var myIngredientListType: MyIngredientListType
    @Inject lateinit var presenter: Presenter
    private val adapter by lazyFast { MyIngredientListAdapter(this, picasso) }

    override fun layoutId() = R.layout.recycler_view

    override fun inject() {
        DaggerMyIngredientListComponent.builder()
            .applicationComponent(App.instance.appComponent())
            .myIngredientListModule(MyIngredientListModule(myIngredientListType))
            .build()
            .inject(this)
    }

    @Inject
    override fun attachPresenter(presenter: Presenter) {
        this.presenter.attachView(this)
    }

    override fun extractArguments() {
        arguments?.let {
            it.getString(ARGS_TYPE)?.let {
                myIngredientListType = when (it) {
                    TYPE_MY_BAR        -> MyIngredientListType.MyBar()
                    TYPE_SHOPPING_LIST -> MyIngredientListType.ShoppingList()
                    else               -> throw IllegalStateException("Unknown type passed via bundle : $it")
                }
            } ?: throw IllegalStateException("Type was not passed in via Bundle")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_rv.adapter = adapter
        rv_rv.layoutManager = GridLayoutManager(activity, 2)
        rv_srl.isEnabled = false

        presenter.start()
    }

    override fun onDestroy() {
        presenter.stop()
        super.onDestroy()
    }

    override fun onClick(item: MyIngredient, sharedElements: List<Pair<View, String>>?) {
        ifAdded { abc ->
            //TODO picasso.subscribeToData(item.imageUrl).fetch() prefetch large image
            navigator.navigate(
                source = abc,
                target = IngredientDetailActivity::class.java,
                //    sharedElements = sharedElements,
                bundle = IngredientDetailActivity.createBundle(item.ingredientId)
            )
        }
    }

    override fun startLoading() {
        rv_srl.isRefreshing = true
    }

    override fun stopLoading() {
        rv_srl.isRefreshing = false
    }

    override fun onNewData(list: List<MyIngredient>) {
        adapter.updateData(list)
    }

    override fun onError(error: Throwable) {
        ifAdded { Toast.makeText(activity, """Error :$error""", Toast.LENGTH_LONG).show() }
    }

    companion object {

        fun newInstance(bundle: Bundle) = MyIngredientListFragment().apply {
            arguments = bundle
        }

        fun createBundle(ingredientListType: MyIngredientListType) = Bundle().apply {

            val typeString = when (ingredientListType) {
                is MyIngredientListType.MyBar        -> TYPE_MY_BAR
                is MyIngredientListType.ShoppingList -> TYPE_SHOPPING_LIST
            }

            putString(ARGS_TYPE, typeString)
        }

        private const val TYPE_MY_BAR = "TYPE_MY_BAR"
        private const val TYPE_SHOPPING_LIST = "TYPE_SHOPPING_LIST"

        private const val ARGS_TYPE = "ARGS_TYPE"
    }
}