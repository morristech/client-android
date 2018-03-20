package com.guru.cocktails.ui.shared

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.support.graphics.drawable.VectorDrawableCompat
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import android.widget.LinearLayout
import android.widget.TextView
import com.guru.cocktails.R
import kotlinx.android.synthetic.main.include_switch_right_text_button.view.*
import timber.log.Timber

/**
 * @author Michal Demcak <michal.demcak@cleverlance.com>
 */
class CocktailCheckButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr), Checkable {

    init {
        View.inflate(context, R.layout.include_switch_right_text_button, this)
        check_box.buttonDrawable = getCheckBoxDrawable()
        attrs?.let(this::setAttributeValues)
    }

    @SuppressLint("Recycle")
    private fun setAttributeValues(attrs: AttributeSet) = with(context.obtainStyledAttributes(attrs, R.styleable.CocktailCheckButton)) {
        (0 until indexCount)
                .map(this::getIndex)
                .forEach {
                    when (it) {
                        R.styleable.CocktailCheckButton_switchRightText -> setText(check_box_right_tv, getString(it))
                        else -> Timber.w("Unknown attribute for " + javaClass.toString() + ": " + it)
                    }
                }
        recycle()
    }

    private fun getCheckBoxDrawable(): StateListDrawable {
        val drawable = StateListDrawable()
        drawable.addState(intArrayOf(android.R.attr.state_checked),
                VectorDrawableCompat.create(resources, R.drawable.ic_cocktail_green, context.theme))
        drawable.addState(intArrayOf(),
                VectorDrawableCompat.create(resources, R.drawable.ic_cocktail_red, context.theme))
        return drawable
    }

    fun setText(switchText: TextView, title: String?) {
        switchText.text = title
    }

    override fun setOnClickListener(listener: View.OnClickListener) {
        super.setOnClickListener { v ->
            toggle()
            listener.onClick(v)
        }
    }

    override fun toggle() {
        check_box.toggle()
    }

    override fun setChecked(checked: Boolean) {
        check_box.isChecked = checked
    }

    override fun isChecked() = check_box.isChecked
}