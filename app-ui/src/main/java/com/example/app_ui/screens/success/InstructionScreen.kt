package com.example.app_ui.screens.success

import com.example.app_ui.common.AppScreen

class InstructionScreen(
    val subtitleRes: Int,
    val iconRes: Int,
    val buttonRes: Int,
    val nextAction: InstructionNextAction,
    val nextScreen: AppScreen? = null,
) : AppScreen() {

    override fun getFragment() = InstructionFragment.newInstance(this)
}

enum class InstructionNextAction{
    NEXT,
    ROOT,
    BACK,
}