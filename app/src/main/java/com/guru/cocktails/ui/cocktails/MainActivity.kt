package com.guru.cocktails.ui.cocktails

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.platform.extensions.lazyFast
import com.guru.cocktails.ui.academy.holder.AcademyHolderFragment
import com.guru.cocktails.ui.bar.holder.BarHolderFragment
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui.base.view.BottomNavigationViewBehavior
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderFragment
import com.guru.cocktails.ui.shared.DrawerItems
import com.guru.cocktails.ui.shared.DrawerManager
import kotlinx.android.synthetic.main.activity_drawer.*


class MainActivity : BaseActivity() {

    private lateinit var drawerManager: DrawerManager

    private val BOTTOM_NAVIGATION_ANIMATION_LENGTH = 300L
    private val TAG_INGREDIENTS = "TAG_INGREDIENTS"
    private val TAG_COCKTAILS = "TAG_COCKTAILS"
    private val TAG_BAR = "TAG_BAR"

    private val POS_COCKTAILS = 0
    private val POS_MY_BAR = 1
    private val POS_PROFILE = 2
    private val POS_ACADEMY = 3
    private val POS_MORE = 4

    private val cocktailsFragment by lazyFast { CocktailsHolderFragment.newInstance() }
    private val academyFragment by lazyFast { AcademyHolderFragment.newInstance() }
    private val barFragment by lazyFast { BarHolderFragment.newInstance() }

    override fun inject() {
        App.instance.appComponent().inject(this)
    }

    override fun layoutId(): Int {
        return R.layout.activity_drawer
    }

    override fun afterLayout(savedInstanceState: Bundle?) {
        super.afterLayout(savedInstanceState)
        drawerManager = DrawerManager(this, DrawerItems.Cocktails())
        showCocktails()
        setUpBottomNavigation()
        setSupportActionBar(toolbar)
    }

    private fun setUpBottomNavigation() {
        val layoutParams = navigation.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationViewBehavior(BOTTOM_NAVIGATION_ANIMATION_LENGTH)

        // Create items
        val item1 = AHBottomNavigationItem(R.string.menu_item_cocktails, R.drawable.ic_cocktail_black_24dp, R.color.md_blue_600)
        val item2 = AHBottomNavigationItem(R.string.menu_item_my_bar, R.drawable.ic_bar_black_24dp, R.color.md_blue_600)
        val item3 = AHBottomNavigationItem(R.string.menu_item_profile, R.drawable.ic_profile_black_24dp, R.color.md_blue_600)
        val item4 = AHBottomNavigationItem(R.string.menu_item_academy, R.drawable.ic_academy_black_24dp, R.color.md_blue_600)
        val item5 = AHBottomNavigationItem(R.string.menu_item_more, R.drawable.ic_more_black_24dp, R.color.md_blue_600)

        // Add items
        navigation.addItem(item1)
        navigation.addItem(item2)
        navigation.addItem(item3)
        navigation.addItem(item4)
        navigation.addItem(item5)

        navigation.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW

        navigation.setOnTabSelectedListener({ position, wasSelected ->
            if (wasSelected)
                true
            when (position) {
                POS_COCKTAILS -> showCocktails()
                POS_MY_BAR    -> showBar()
                POS_PROFILE   -> showCocktails()
                POS_ACADEMY   -> showAcademy()
                POS_MORE      -> showBar()
            }
            true
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //TODO show dialog about quiting after 2nd press
    }

    private fun showAcademy() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.am_fl_btn, academyFragment, TAG_INGREDIENTS)
        transaction.commit()
    }

    private fun showCocktails() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.am_fl_btn, cocktailsFragment, TAG_COCKTAILS)
        transaction.commit()
    }

    private fun showBar() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.am_fl_btn, barFragment, TAG_BAR)
        transaction.commit()
    }

}