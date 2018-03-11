package com.guru.cocktails.ui.base;

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.guru.cocktails.platform.analytics.AnalyticsManager
import com.guru.cocktails.platform.bus.event.EventBus
import com.guru.cocktails.platform.connectivity.ConnectivityChecker
import com.guru.cocktails.platform.extensions.lazyFast
import com.guru.cocktails.platform.navigation.Navigator
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity(), ConnectivityChecker.Callbacks {

    private val connectivityChecker: ConnectivityChecker by lazyFast { initializeConnectivityChecker() }
    protected val disposables = CompositeDisposable()

    @Inject lateinit var eventBus: EventBus
    @Inject lateinit var navigator: Navigator
    @Inject lateinit var analyticsManager: AnalyticsManager
    @Inject lateinit var picasso: Picasso

    protected abstract fun inject()
    protected open fun afterLayout(savedInstanceState: Bundle?) {}
    protected open fun onViewsBound() {}
    protected open fun extractArguments() {}
    @LayoutRes protected abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        extractArguments()
        inject()
        setContentView(layoutId())
        afterLayout(savedInstanceState)
        onViewsBound()
    }

    @CallSuper
    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        connectivityChecker.start()
    }

    override fun onPause() {
        super.onPause()
        connectivityChecker.stop()
    }

    private fun initializeConnectivityChecker(): ConnectivityChecker {
        return ConnectivityChecker(getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager, this)
    }

    override fun onConnected() {
        Timber.i("Internet connection is ON!!")
    }

    override fun onDisconnected() {
        Timber.i("Internet connection is OFF!!")
    }
}
