package com.guru.cocktails.ui.bar.holder

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.ui.bar.holder.BarHolderContract.Presenter
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListFragment
import com.guru.cocktails.ui.bar.ingredientlist.Type
import com.guru.cocktails.ui.base.BaseFragment
import com.guru.cocktails.ui.base.view.SectionsPagerAdapter
import kotlinx.android.synthetic.main.fragment_tabs.*
import javax.inject.Inject

class BarHolderFragment : BaseFragment(), BarHolderContract.View {

    private var presenter: Presenter? = null

    override fun layoutId() = R.layout.fragment_tabs

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
        initialize()
        presenter?.start()
    }

    override fun onDestroy() {
        presenter?.stop()
        super.onDestroy()
    }

    private fun initialize() {
        setupViewPager(view_pager)
        tab_layout.setupWithViewPager(view_pager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsPagerAdapter(childFragmentManager)
        val alcoBundle = IngredientListFragment.createBundle(Type.Alcoholic())
        val alcoNonBundle = IngredientListFragment.createBundle(Type.NonAlcoholic())

        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "INTRO")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "MY COCKTAILS")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "MY BAR")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "SUGGESTIONS")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "SHOPPING LIST")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "ALCOHOLIC")
        adapter.addFragment(IngredientListFragment.newInstance(alcoNonBundle), "NON ALCOHOLIC")

        viewPager.adapter = adapter
    }

    companion object {
        fun newInstance(): BarHolderFragment {
            return BarHolderFragment()
        }
    }
}