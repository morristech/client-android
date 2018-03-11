package com.guru.cocktails.ui.bar.holder

import com.guru.cocktails.ui.bar.ingredientlist.IngredientListFragment
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListType
import com.guru.cocktails.ui.base.BaseHolderFragment

class BarHolderFragment : BaseHolderFragment() {

    override fun addFragments() {

        val alcoBundle = IngredientListFragment.createBundle(IngredientListType.Alcoholic())
        val alcoNonBundle = IngredientListFragment.createBundle(IngredientListType.NonAlcoholic())

        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "INTRO")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "MY COCKTAILS")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "MY BAR")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "SUGGESTIONS")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "SHOPPING LIST")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "ALCOHOLIC")
        adapter.addFragment(IngredientListFragment.newInstance(alcoNonBundle), "NON ALCOHOLIC")
    }

    companion object {
        fun newInstance(): BarHolderFragment {
            return BarHolderFragment()
        }
    }
}