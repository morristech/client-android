package com.guru.cocktails.ui.description

import android.animation.Animator
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_description.*


class DescriptionActivity : BaseActivity() {

    override fun layoutId() = R.layout.activity_description

    override fun onViewsBound() {
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val des = intent.getStringExtra(EXTRA_DESCRIPTION)
        supportActionBar?.title = title
        des?.let { ad_tv_content.text = it }

    }

    override fun inject() {
        App.instance.appComponent().inject(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    /* ad_nsv.post({
             val anim = animateRevealColorFromCoordinates(ad_nsv, android.R.color.white, ad_nsv.width / 2, 0)
             anim.addListener(object : AnimatorListenerAdapter() {
                 override fun onAnimationEnd(animation: Animator) {
                 }
             })
             des?.let { ad_tv_content.text = it }
         })*/
    private fun animateRevealColorFromCoordinates(viewRoot: ViewGroup, @ColorRes color: Int, x: Int, y: Int): Animator {
        val finalRadius = Math.hypot(viewRoot.width.toDouble(), viewRoot.height.toDouble()).toFloat()

        val anim = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, 0f, finalRadius)
        viewRoot.setBackgroundColor(ContextCompat.getColor(this, color))
        //  anim.duration = resources.getInteger(R.integer.anim_duration_long).toLong()
        anim.duration = 500
        anim.interpolator = AccelerateDecelerateInterpolator()
        anim.start()
        return anim
    }

    companion object {

        fun newBundle(title: String, description: String): Bundle {
            val bundle = Bundle()
            bundle.putString(EXTRA_TITLE, title)
            bundle.putString(EXTRA_DESCRIPTION, description)
            return bundle
        }

        private val EXTRA_TITLE = "EXTRA_TITLE"
        private val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"
    }

}
