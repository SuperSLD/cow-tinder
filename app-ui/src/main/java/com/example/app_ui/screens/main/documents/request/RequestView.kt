package com.example.app_ui.screens.main.documents.request

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import online.juter.supersld.view.input.form.JTForm

interface RequestView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showForm(form: JTForm)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun toggleLoading(show: Boolean)
}
