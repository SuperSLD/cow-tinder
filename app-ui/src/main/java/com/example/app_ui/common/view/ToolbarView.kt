package com.example.app_ui.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.app_ui.R
import com.example.app_ui.common.core.base.addSystemTopPadding
import kotlinx.android.synthetic.main.view_toolbar.view.TVicClose
import kotlinx.android.synthetic.main.view_toolbar.view.TVtoolbar
import kotlinx.android.synthetic.main.view_toolbar.view.TVtvTitle

class ToolbarView : RelativeLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    init {
        View.inflate(context, R.layout.view_toolbar, this)
        TVtoolbar.addSystemTopPadding()
    }

    /**
     * Инициализация тулбара.
     */

    fun init(
        title: String = "",
        back: (() -> Unit)? = null,
    ) {
        TVtvTitle.text = title

        if (back != null) {
            TVicClose.visibility = View.VISIBLE
            TVicClose.setOnClickListener { back() }
        }
    }
}