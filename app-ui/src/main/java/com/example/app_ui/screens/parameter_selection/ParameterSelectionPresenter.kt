package com.example.app_ui.screens.parameter_selection

import com.arellomobile.mvp.InjectViewState
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class ParameterSelectionPresenter(
    private val params: ParameterSelectionScreen
): BasePresenter<ParameterSelectionView>() {

    private var maxParam = 0

    fun onBack() = router?.exit()

    fun onSearch(
        cowTag: String,

    ) {

    }

    fun onMainParameterChange(maximisationParam: Int) {
        maxParam = maximisationParam
    }
}