package com.guru.cocktails.ui.academy.holder

import com.guru.cocktails.ui.bar.ingredientlist.IngredientListFragment
import com.guru.cocktails.ui.bar.ingredientlist.IngredientListType
import com.guru.cocktails.ui.base.BaseHolderFragment

class AcademyHolderFragment : BaseHolderFragment() {

    override fun addFragments() {
        val alcoBundle = IngredientListFragment.createBundle(IngredientListType.Alcoholic())
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "TOOLS")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "GLASSWARE")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "GARNISHES")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "COCKTAIL TYPES")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "TECHNIQUES")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "TERMINOLOGY")
    }

    companion object {
        fun newInstance(): AcademyHolderFragment {
            return AcademyHolderFragment()
        }
    }
}