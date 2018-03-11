package com.guru.cocktails.ui.academy.holder

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.ui.academy.holder.AcademyHolderContract.Presenter
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListFragment
import com.guru.cocktails.ui.bar.ingredientlist.Type
import com.guru.cocktails.ui.base.BaseFragment
import com.guru.cocktails.ui.base.view.SectionsPagerAdapter
import kotlinx.android.synthetic.main.fragment_tabs.*
import javax.inject.Inject

class AcademyHolderFragment : BaseFragment(), AcademyHolderContract.View {

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

        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "TOOLS")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "GLASSWARE")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "GARNISHES")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "COCKTAIL TYPES")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "TECHNIQUES")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "TERMINOLOGY")

        viewPager.adapter = adapter
    }

    companion object {
        fun newInstance(): AcademyHolderFragment {
            return AcademyHolderFragment()
        }
    }
}