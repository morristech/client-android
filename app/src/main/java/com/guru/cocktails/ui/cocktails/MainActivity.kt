package com.guru.cocktails.ui.cocktails

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.platform.extensions.lazyFast
import com.guru.cocktails.ui.bar.holder.BarHolderFragment
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui.base.view.BottomNavigationViewBehavior
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderFragment
import com.guru.cocktails.ui.ingredients.holder.IngredientsHolderFragment
import com.guru.cocktails.ui.shared.DrawerItems
import com.guru.cocktails.ui.shared.DrawerManager
import kotlinx.android.synthetic.main.activity_drawer.*

class MainActivity : BaseActivity() {

    private lateinit var drawerManager: DrawerManager

    private val BOTTOM_NAVIGATION_ANIMATION_LENGTH = 300L
    private val TAG_INGREDIENTS = "TAG_INGREDIENTS"
    private val TAG_COCKTAILS = "TAG_COCKTAILS"
    private val TAG_BAR = "TAG_BAR"

    private val cocktailsFragment by lazyFast { CocktailsHolderFragment.newInstance() }
    private val ingredientsFragment by lazyFast { IngredientsHolderFragment.newInstance() }
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
    }

    private fun setUpBottomNavigation() {
        val layoutParams = navigation.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationViewBehavior(BOTTOM_NAVIGATION_ANIMATION_LENGTH)

        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_recent -> {
                    showCocktails()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_favorites -> {
                    showIngredients()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_nearby -> {
                    showBar()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //TODO show dialog about quiting after 2nd press
    }

    private fun showIngredients() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.am_fl_btn, ingredientsFragment, TAG_INGREDIENTS)
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