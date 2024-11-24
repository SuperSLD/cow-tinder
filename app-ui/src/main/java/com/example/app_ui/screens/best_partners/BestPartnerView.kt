package com.example.app_ui.screens.best_partners

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.app_domain.models.cow.Cow

interface BestPartnerView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCowList(cowList: List<Cow>)
}