package com.guru.cocktails.ui.ingredient

import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.GridLayoutManager
import android.transition.TransitionInflater
import android.view.View
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui.cocktails.CocktailViewModel
import com.guru.cocktails.ui.description.DescriptionActivity
import kotlinx.android.synthetic.main.activity_ingredient.*
import javax.inject.Inject

class IngredientActivity : BaseActivity(), IngredientContract.View {

    private var presenter: IngredientContract.Presenter? = null

    override fun layoutId() = R.layout.activity_ingredient

    override fun onCreate(savedInstanceState: Bundle?) {
        window.enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode)
        super.onCreate(savedInstanceState)
    }

    override fun onViewsBound() {

        presenter?.start()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title = "White rum"

        val cocktails = listOf(
            CocktailViewModel(1L, "1"),
            CocktailViewModel(1L, "2"),
            CocktailViewModel(1L, "3"),
            CocktailViewModel(1L, "4"),
            CocktailViewModel(1L, "1"),
            CocktailViewModel(1L, "2"),
            CocktailViewModel(1L, "3"),
            CocktailViewModel(1L, "4")
        )

        val manager = GridLayoutManager(this, 2)
        val adapterAbc = CocktailsAdapter()
        adapterAbc.updateData(cocktails)
        ai_rv.layoutManager = manager
        ai_rv.adapter = adapterAbc
        ai_rv.isNestedScrollingEnabled = false

        ai_ll_description.setOnClickListener {
            val pairs = listOf(Pair(place_detail as View, "description"),Pair(image as View, "image"))
            val bundle = DescriptionActivity.newBundle("White Rummmmmmmmmmmmm", "Much is made of the word's two spellings: whiskey and whisky.[3][4] There are two schools of thought on the issue. One is that the spelling difference is simply a matter of regional language convention for the spelling of a word, indicating that the spelling varies depending on the intended audience or the background or personal preferences of the writer (like the difference between color and colour; or recognize and recognise),[3][4] and the other is that the spelling should depend on the style or origin of the spirit being described. There is general agreement that when quoting the proper name printed on a label, the spelling on the label should not be altered.[3][4] Some writers[who?] refer to \"whisk(e)y\" or \"whisky/whiskey\" to acknowledge the variation.,Much is made of the word's two spellings: whiskey and whisky.[3][4] There are two schools of thought on the issue. One is that the spelling difference is simply a matter of regional language convention for the spelling of a word, indicating that the spelling varies depending on the intended audience or the background or personal preferences of the writer (like the difference between color and colour; or recognize and recognise),[3][4] and the other is that the spelling should depend on the style or origin of the spirit being described. There is general agreement that when quoting the proper name printed on a label, the spelling on the label should not be altered.[3][4] Some writers[who?] refer to \"whisk(e)y\" or \"whisky/whiskey\" to acknowledge the variation.,Much is made of the word's two spellings: whiskey and whisky.[3][4] There are two schools of thought on the issue. One is that the spelling difference is simply a matter of regional language convention for the spelling of a word, indicating that the spelling varies depending on the intended audience or the background or personal preferences of the writer (like the difference between color and colour; or recognize and recognise),[3][4] and the other is that the spelling should depend on the style or origin of the spirit being described. There is general agreement that when quoting the proper name printed on a label, the spelling on the label should not be altered.[3][4] Some writers[who?] refer to \"whisk(e)y\" or \"whisky/whiskey\" to acknowledge the variation.,Much is made of the word's two spellings: whiskey and whisky.[3][4] There are two schools of thought on the issue. One is that the spelling difference is simply a matter of regional language convention for the spelling of a word, indicating that the spelling varies depending on the intended audience or the background or personal preferences of the writer (like the difference between color and colour; or recognize and recognise),[3][4] and the other is that the spelling should depend on the style or origin of the spirit being described. There is general agreement that when quoting the proper name printed on a label, the spelling on the label should not be altered.[3][4] Some writers[who?] refer to \"whisk(e)y\" or \"whisky/whiskey\" to acknowledge the variation.,Much is made of the word's two spellings: whiskey and whisky.[3][4] There are two schools of thought on the issue. One is that the spelling difference is simply a matter of regional language convention for the spelling of a word, indicating that the spelling varies depending on the intended audience or the background or personal preferences of the writer (like the difference between color and colour; or recognize and recognise),[3][4] and the other is that the spelling should depend on the style or origin of the spirit being described. There is general agreement that when quoting the proper name printed on a label, the spelling on the label should not be altered.[3][4] Some writers[who?] refer to \"whisk(e)y\" or \"whisky/whiskey\" to acknowledge the variation.")
            navigator.navigate(this, DescriptionActivity::class.java, bundle, pairs)
        }
    }

    override fun inject() {
        DaggerViewComponent.builder()
            .presenterModule(PresenterModule())
            .applicationComponent(App.instance.appComponent())
            .build()
            .inject(this)
    }

    @Inject
    override fun attachPresenter(presenter: IngredientContract.Presenter) {
        this.presenter = presenter
        this.presenter?.attachView(this)
    }

    override fun onDestroy() {
        presenter?.stop()
        super.onDestroy()
    }
}
