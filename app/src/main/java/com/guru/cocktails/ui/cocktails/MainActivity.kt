package com.guru.cocktails.ui.cocktails

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.platform.extensions.lazyFast
import com.guru.cocktails.ui.bar.holder.BarHolderFragment
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui.cocktails.holder.CocktailsHolderFragment
import com.guru.cocktails.ui.ingredients.holder.IngredientsHolderFragment
import com.guru.cocktails.ui.shared.DrawerItems
import com.guru.cocktails.ui.shared.DrawerManager
import kotlinx.android.synthetic.main.activity_drawer.*



class MainActivity : BaseActivity() {

    private lateinit var drawerManager: DrawerManager

    private val TAG_INGREDIENTS = "TAG_INGREDIENTS"
    private val TAG_COCKTAILS = "TAG_COCKTAILS"
    private val TAG_BAR = "TAG_BAR"
    var isNavigationHide = false

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

    private fun animateNavigation(hide: Boolean) {
        if (isNavigationHide && hide || !isNavigationHide && !hide) return
        isNavigationHide = hide
        val moveY = if (hide) 2 * navigation.height else 0
        navigation.animate().translationY(moveY.toFloat()).setStartDelay(100).setDuration(300).start()
    }
}