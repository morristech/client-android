package com.guru.cocktails.ui.cocktails.holder

import com.guru.cocktails.ui.bar.ingredientlist.IngredientListFragment
import com.guru.cocktails.ui.bar.ingredientlist.Type
import com.guru.cocktails.ui.base.BaseHolderFragment
import com.guru.cocktails.ui.cocktails.cocktailslist.CocktailListFragment

class CocktailsHolderFragment : BaseHolderFragment() {

    override fun addFragments() {
        val alcoBundle = IngredientListFragment.createBundle(Type.Alcoholic())
        adapter.addFragment(CocktailListFragment.newInstance(), "INTRO")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "IBA")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "TOP 100")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "PACKAGES")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "ALCOHOL FREE")
        adapter.addFragment(IngredientListFragment.newInstance(alcoBundle), "RANDOM")
    }

    companion object {
        fun newInstance(): CocktailsHolderFragment {
            return CocktailsHolderFragment()
        }
    }
}