package com.guru.cocktails.platform.extensions

import android.support.v4.app.Fragment

/**
 * Check if fragment is still added to activity
 */
fun Fragment.ifAdded(function: () -> Unit) {
    if (isAdded) {
        function.invoke()
    }
}
