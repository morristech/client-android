package com.guru.cocktails.platform.extensions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import timber.log.Timber

/**
 * Check if fragment is still added to activity
 */
fun Fragment.ifAdded(function: (activity: FragmentActivity) -> Unit) {
    if (isAdded) {
        activity?.let { function.invoke(it) }
    } else {
        Timber.e("Activity was null")
    }
}