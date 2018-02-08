package com.guru.cocktails.ui._remove.example1

import android.os.Bundle
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui._remove.example1.fragment.Example1Fragment
import timber.log.Timber

/**
 * Example 1 shows how to inject your presenters within Fragment level and how to get data from
 * local and remote
 */
class Example1Activity : BaseActivity() {

    override fun layoutId() = R.layout.activity_weather

    override fun afterLayout(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            bindFragment()
        }
        extractParcelable()
    }

    private fun extractParcelable() {
        intent.extras.getParcelable<ExampleParcelable>("parcelable")?.let {
            Timber.i("Parcelable  message = ${it.message}")
        }
    }

    private fun bindFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, Example1Fragment.newInstance())
            .commit()
    }

    override fun inject() {
        DaggerViewComponent.builder()
            .applicationComponent(App.instance.appComponent())
            .build().inject(this)
    }
}
