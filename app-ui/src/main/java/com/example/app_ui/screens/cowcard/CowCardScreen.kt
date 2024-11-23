package com.example.app_ui.screens.cowcard

import com.example.app_domain.models.cow.Cow
import com.example.app_ui.common.AppScreen

class CowCardScreen(
    val cow: Cow,
    val nextAction: CowCardNextAction,
    val nextScreen: AppScreen? = null,
) : AppScreen() {

    override fun getFragment() = CowCardFragment.newInstance(this)
}

enum class CowCardNextAction{
    NEXT,
    ROOT,
    BACK,
}