package com.example.app_ui.screens.main.education.course.lesson.result

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ResultView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showResult(result: Pair<Int, Int>)
}
