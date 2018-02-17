package com.guru.cocktails.platform.navigation

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.FragmentActivity
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.view.View

class Navigator {

    fun navigate(source: FragmentActivity, target: Class<out AppCompatActivity>, bundle: Bundle? = null, sharedElements: List<Pair<View, String>>? = null) {
        val intent = Intent(source, target)
        bundle?.let { intent.putExtras(it) }

        val pairs = TransitionHelper.createSafeTransitionParticipants(source, true, sharedElements)
        val transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(source, *pairs)
        source.startActivity(intent, transitionActivityOptions.toBundle())
    }
}