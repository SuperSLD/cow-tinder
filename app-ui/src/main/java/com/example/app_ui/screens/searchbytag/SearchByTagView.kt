package com.example.app_ui.screens.searchbytag

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SearchByTagView : MvpView {

    fun toggleLoading(show: Boolean)

    fun changeType(isTag: Boolean)

    @StateStrategyType(SkipStrategy::class)
    fun showErrorToast(text: String)
}
