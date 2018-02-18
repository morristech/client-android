package com.guru.cocktails.ui.base.view


import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.view.View


class BottomNavigationViewBehavior(private val animationDuration: Long) : CoordinatorLayout.Behavior<BottomNavigationView>() {

    private var height: Int = 0
    private var isNavigationHide = false

    override fun onLayoutChild(parent: CoordinatorLayout, child: BottomNavigationView, layoutDirection: Int): Boolean {
        height = child.height
        return super.onLayoutChild(parent, child, layoutDirection)
    }

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomNavigationView,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int): Boolean {

        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomNavigationView,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int, dyUnconsumed: Int,
        @ViewCompat.NestedScrollType type: Int) {

        if (dyConsumed > 0) {
            animateNavigation(child = child, hide = true)
        } else if (dyConsumed < 0) {
            animateNavigation(child = child, hide = false)
        }
    }

    private fun animateNavigation(child: BottomNavigationView, hide: Boolean) {
        if (isNavigationHide && hide || !isNavigationHide && !hide) return
        isNavigationHide = hide
        val moveY = if (hide) 2 * child.height else 0
        child.animate().translationY(moveY.toFloat()).setStartDelay(100).setDuration(animationDuration).start()
    }
}
