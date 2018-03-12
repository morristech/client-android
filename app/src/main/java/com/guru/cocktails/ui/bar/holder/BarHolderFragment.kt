package com.guru.cocktails.ui.bar.holder

import com.guru.cocktails.ui.bar.ingredientlist.IngredientListFragment
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListType.Alcoholic
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListType.NonAlcoholic
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListFragment
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListType.MyBar
import com.guru.cocktails.ui.bar.myingredients.MyIngredientListType.ShoppingList
import com.guru.cocktails.ui.base.BaseHolderFragment

class BarHolderFragment : BaseHolderFragment() {

    override fun addFragments() {

        val alcoBundle = IngredientListFragment.createBundle(Alcoholic())
        val alcoNonBundle = IngredientListFragment.createBundle(NonAlcoholic())

        val myBarBundle = MyIngredientListFragment.createBundle(MyBar())
        val shoppingListBundle = MyIngredientListFragment.createBundle(ShoppingList())

        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "INTRO")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "MY COCKTAILS")
        adapter.addFragment(MyIngredientListFragment.newInstance(myBarBundle), "MY BAR")
        adapter.addFragment(MyIngredientListFragment.newInstance(shoppingListBundle), "SHOPPING LIST")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "SUGGESTIONS")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "ALCOHOLIC")
        adapter.addFragment(IngredientListFragment.newInstance(alcoNonBundle), "NON ALCOHOLIC")
    }

    companion object {
        fun newInstance(): BarHolderFragment {
            return BarHolderFragment()
        }
    }
}