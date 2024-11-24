package com.example.app_ui.screens.parameter_selection

import androidx.fragment.app.Fragment
import com.example.app_ui.common.AppScreen

class ParameterSelectionScreen(
    val cowId: String
): AppScreen() {

    override fun getFragment(): Fragment = ParameterSelectionFragment.newInstance(this)
}