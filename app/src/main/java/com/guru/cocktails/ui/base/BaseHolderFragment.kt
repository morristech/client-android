package com.guru.cocktails.ui.base

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.platform.extensions.lazyFast
import com.guru.cocktails.ui.base.view.SectionsPagerAdapter
import kotlinx.android.synthetic.main.fragment_tabs.*

open class BaseHolderFragment : BaseFragment() {

    protected val adapter by lazyFast { SectionsPagerAdapter(childFragmentManager) }

    override fun layoutId() = R.layout.fragment_tabs

    override fun inject() {
        App.instance.appComponent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragments()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        setupViewPager(view_pager)
        tab_layout.setupWithViewPager(view_pager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        viewPager.adapter = adapter
    }

    open fun addFragments() {}
}