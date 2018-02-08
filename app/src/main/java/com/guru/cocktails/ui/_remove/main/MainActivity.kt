package com.guru.cocktails.ui._remove.main

import android.os.Bundle
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.ui.academy.AcademyActivity
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui._remove.example1.Example1Activity
import com.guru.cocktails.ui._remove.example1.ExampleParcelable
import com.guru.cocktails.ui._remove.example3.Example3Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun layoutId() = R.layout.activity_main

    override fun onViewsBound() {
        logAnalytics()
        btn_one.setOnClickListener { button1Clicked() }
        btn_two.setOnClickListener { button2Clicked() }
        btn_three.setOnClickListener { button3Clicked() }
    }

    override fun inject() {
        DaggerViewComponent.builder()
            .applicationComponent(App.instance.appComponent())
            .build().inject(this)
    }

    private fun button1Clicked() {
        val dummy = ExampleParcelable("Hello from here")
        val bundle = Bundle()
        bundle.putParcelable("parcelable", dummy)
        navigator.navigate(this, Example1Activity::class.java, bundle)
    }

    private fun button2Clicked() {
        navigator.navigate(this, AcademyActivity::class.java)
    }

    private fun button3Clicked() {
        navigator.navigate(this, Example3Activity::class.java)
    }

    /**
     * This in an example how to use [com.guru.cocktails.platform.analytics.AnalyticsManager] to
     * track events.
     */
    private fun logAnalytics() {

        analyticsManager.setUser("john@doe.com")

        analyticsManager.trackEvent("Activity 1")

        val map = hashMapOf("userRole" to "admin", "userAge" to 30, "isPremiumUser" to true)
        analyticsManager.trackEvent("Activity 2", map)
    }
}