package com.guru.cocktails.ui.cocktails

import android.os.Bundle
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui.shared.DrawerItems
import com.guru.cocktails.ui.shared.DrawerManager


class CocktailsActivity : BaseActivity() {

    private lateinit var drawerManager: DrawerManager

    override fun inject() {
        App.instance.appComponent().inject(this)
    }

    override fun layoutId(): Int {
        return R.layout.activity_drawer
    }

    override fun afterLayout(savedInstanceState: Bundle?) {
        super.afterLayout(savedInstanceState)
        drawerManager = DrawerManager(this, DrawerItems.Cocktails())
    }
}