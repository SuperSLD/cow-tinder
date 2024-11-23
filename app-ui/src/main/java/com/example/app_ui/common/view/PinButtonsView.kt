package com.example.app_ui.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.app_ui.R
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv0
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv1
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv2
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv3
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv4
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv5
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv6
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv7
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv8
import kotlinx.android.synthetic.main.view_pin_buttons.view.cv9
import kotlinx.android.synthetic.main.view_pin_buttons.view.cvDel

class PinButtonsView  : RelativeLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    private var delete = {}
    private var add = {_:String->}

    init {
        View.inflate(context, R.layout.view_pin_buttons, this)

        cvDel.setOnClickListener {
            delete()
        }
        cvDel.visibility = View.INVISIBLE

        val list = mutableListOf(
            cv0, cv1, cv2, cv3, cv4, cv5, cv6, cv7, cv8, cv9
        )
        for (i in list.indices) {
            list[i].setOnClickListener {
                add(i.toString())
            }
        }
    }

    /**
     * Сюда необходимо передать
     * обновление пинкода, чтобы отображать
     * кнопку удаления или события справа.
     */
    fun updateState(value: String) {
        if (value.isEmpty()) {
            cvDel.visibility = View.INVISIBLE
        } else {
            cvDel.visibility = View.VISIBLE
        }
    }

    /**
     * Удаление текста в инпуте.
     */
    fun onDelete(delete: ()->Unit) {
        this.delete = delete
    }

    /**
     * Добавление текста в инпут.
     */
    fun onAdd(add: (String)->Unit) {
        this.add = add
    }
}