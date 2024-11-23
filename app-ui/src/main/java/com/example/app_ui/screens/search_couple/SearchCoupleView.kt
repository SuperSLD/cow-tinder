package com.example.app_ui.screens.search_couple

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.app_domain.models.cow.Cow

interface SearchCoupleView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCowList(cowList: List<Cow>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun toggleLoading(show: Boolean)
}