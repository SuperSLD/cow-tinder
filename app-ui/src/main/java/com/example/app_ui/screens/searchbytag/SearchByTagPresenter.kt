package com.example.app_ui.screens.searchbytag

import com.arellomobile.mvp.InjectViewState
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class SearchByTagPresenter : BasePresenter<SearchByTagView>() {

    fun searchByTag(tag: String) {

    }

    fun onBack() = router?.exit()
}