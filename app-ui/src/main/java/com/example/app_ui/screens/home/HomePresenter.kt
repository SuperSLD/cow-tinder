package com.example.app_ui.screens.home

import com.arellomobile.mvp.InjectViewState
import com.example.app_ui.screens.searchbytag.SearchByTagScreen
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class HomePresenter : BasePresenter<HomeView>() {

    fun onOpenNewCowProcess() {

    }

    fun onOpenCowInfoProcess() {
        router?.navigateTo(SearchByTagScreen())
    }

    fun onOpenCowSexProcess() {

    }

    fun onOpenCowInventoryProcess() {

    }

    fun onBack() = router?.exit()
}