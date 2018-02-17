package com.guru.cocktails.ui.shared

import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import com.guru.cocktails.App
import com.guru.cocktails.platform.navigation.Navigator
import com.guru.cocktails.ui.base.BaseActivity
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import javax.inject.Inject


class DrawerManager(private val activity: BaseActivity, private val type: DrawerItems) {

    @Inject lateinit var navigator: Navigator

    val drawer: Drawer

    init {
        App.instance.appComponent().inject(this)
        drawer = initializeDrawer()
    }

    private fun initializeDrawer(): Drawer {

        val drawerBuilder = DrawerBuilder()
            .withActivity(activity)
            .withAccountHeader(buildDrawerHeader())
            .withActionBarDrawerToggle(true)

        val newDrawer = drawerBuilder.build()
/*
        val cocktailsItem = buildPrimaryItem(type is Cocktails, getString(R.string.drawer_item_cocktails), { buildClickListener(Cocktails(), MainActivity::class.java) })
        val ingredientsItem = buildPrimaryItem(type is Ingredients, getString(R.string.drawer_item_ingredients), { buildClickListener(Ingredients(), IngredientsHolderFragment::class.java) })
        val academyItem = buildPrimaryItem(type is Academy, getString(R.string.drawer_item_academy), { buildClickListener(Academy(), AcademyActivity::class.java) })

        newDrawer.addItem(cocktailsItem)
        newDrawer.addItem(ingredientsItem)
        newDrawer.addItem(academyItem)*/

        return newDrawer
    }

    private fun buildClickListener(itemType: DrawerItems, target: Class<out AppCompatActivity>) {
        if (itemType == type) {
            drawer.closeDrawer()
        } else {
            activity.finishAfterTransition()
            navigator.navigate(activity, target)
        }
    }

    private fun buildPrimaryItem(selected: Boolean = false, title: String, clickListener: () -> Unit): PrimaryDrawerItem {
        return PrimaryDrawerItem()
            .withName(title)
            .withSelectable(false)
            .withSetSelected(selected)
            .withOnDrawerItemClickListener { _, _, _ ->
                clickListener.invoke()
                true
            }
    }

    private fun buildSecondaryItem(title: String, clickListener: () -> Unit): SecondaryDrawerItem {
        return SecondaryDrawerItem()
            .withName(title)
            .withSelectable(true)
            .withOnDrawerItemClickListener { _, _, _ ->
                clickListener.invoke()
                true
            }
    }

    private fun buildDrawerHeader(): AccountHeader {
        return AccountHeaderBuilder()
            .withActivity(activity)
            .withOnAccountHeaderListener { _, _, _ -> true }
            .withHeaderBackground(android.R.color.black)
            .withProfiles(listOf(ProfileDrawerItem().withName("Misko Demcak").withEmail("misko@demcak.com")))
            .withProfileImagesClickable(false)
            .withProfileImagesVisible(false)
            .build()
    }

    private fun getString(@StringRes resID: Int): String = activity.getString(resID)

}