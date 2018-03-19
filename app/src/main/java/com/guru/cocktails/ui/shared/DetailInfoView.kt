package com.guru.cocktails.ui.shared

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.guru.cocktails.R
import kotlinx.android.synthetic.main.include_detail_info_view.view.*
import timber.log.Timber

/**
 * @author Michal Demcak <michal.demcak@cleverlance.com>
 */
class DetailInfoView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        View.inflate(context, R.layout.include_detail_info_view, this)
        attrs?.let(this::setAttributeValues)
    }

    @SuppressLint("Recycle")
    private fun setAttributeValues(attrs: AttributeSet) = with(context.obtainStyledAttributes(attrs, R.styleable.DetailInfoView)) {
        (0 until indexCount)
                .map(this::getIndex)
                .forEach {
                    when (it) {
                        R.styleable.DetailInfoView_srcIconOne -> setIcon(image_one, getResourceId(it, 0))
                        R.styleable.DetailInfoView_srcIconTwo -> setIcon(image_two, getResourceId(it, 0))
                        R.styleable.DetailInfoView_srcIconThree -> setIcon(image_three, getResourceId(it, 0))
                        R.styleable.DetailInfoView_srcIconFour -> setIcon(image_four, getResourceId(it, 0))
                        R.styleable.DetailInfoView_infoTextOne -> setInfoText(info_text_one, getString(it))
                        R.styleable.DetailInfoView_infoTextTwo -> setInfoText(info_text_two, getString(it))
                        R.styleable.DetailInfoView_infoTextThree -> setInfoText(info_text_three, getString(it))
                        R.styleable.DetailInfoView_infoTextFour -> setInfoText(info_text_four, getString(it))
                        else -> Timber.w("Unknown attribute for " + javaClass.toString() + ": " + it)
                    }
                }
        recycle()
    }

    fun setIcon(icon: ImageView, iconRes: Int) = icon.setImageResource(iconRes)

    fun setInfoText(infoText: TextView, title: String?) {
        infoText.text = title
    }
}