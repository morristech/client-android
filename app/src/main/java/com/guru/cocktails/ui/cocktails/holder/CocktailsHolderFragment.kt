package com.guru.cocktails.ui.cocktails.holder

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.ui.bar.ingredients.IngredientsFragment
import com.guru.cocktails.ui.bar.ingredients.Type
import com.guru.cocktails.ui.base.BaseFragment
import com.guru.cocktails.ui.base.SectionsPagerAdapter
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderContract.Presenter
import kotlinx.android.synthetic.main.fragment_tabs.*
import javax.inject.Inject

class CocktailsHolderFragment : BaseFragment(), CocktailsHolderContract.View {

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
        val alcoBundle = IngredientsFragment.createBundle(Type.Alcoholic())

        adapter.addFragment(IngredientsFragment.newInstance(alcoBundle), "INTRO")
        adapter.addFragment(IngredientsFragment.newInstance(alcoBundle), "IBA")
        adapter.addFragment(IngredientsFragment.newInstance(alcoBundle), "TOP 100")
        adapter.addFragment(IngredientsFragment.newInstance(alcoBundle), "PACKAGES")
        adapter.addFragment(IngredientsFragment.newInstance(alcoBundle), "ALCOHOL FREE")
        adapter.addFragment(IngredientsFragment.newInstance(alcoBundle), "RANDOM")

        viewPager.adapter = adapter
    }

    companion object {
        fun newInstance(): CocktailsHolderFragment {
            return CocktailsHolderFragment()
        }
    }
}