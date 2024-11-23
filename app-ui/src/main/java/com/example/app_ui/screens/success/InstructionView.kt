package com.example.app_ui.screens.success

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface InstructionView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setContent(subtitle: Int, icon: Int, buttonTitle: Int)
}