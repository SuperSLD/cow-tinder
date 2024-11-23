package com.example.app_ui.screens.cowcard

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.app_domain.models.cow.Cow

@StateStrategyType(AddToEndSingleStrategy::class)
interface CowCardView : MvpView {

    fun showCow(cow: Cow)
}
