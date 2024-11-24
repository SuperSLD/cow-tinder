package com.example.app_ui.screens.paircowcard

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.app_domain.models.cow.Cow
import com.example.app_domain.models.cow.CowPairResult

@StateStrategyType(AddToEndSingleStrategy::class)
interface PairCowCardView : MvpView {

    fun showCow(cowPairResult: CowPairResult)
}
