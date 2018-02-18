package com.guru.cocktails.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guru.cocktails.platform.bus.event.EventBus
import com.guru.cocktails.platform.navigation.Navigator
import com.squareup.picasso.Picasso
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject lateinit var eventBus: EventBus
    @Inject lateinit var navigator: Navigator
    @Inject lateinit var picasso: Picasso

    open fun initializeDependencies() {}
    protected open fun extractArguments() {}
    @LayoutRes protected abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeDependencies()
        extractArguments()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }
}