package com.example.app_ui.screens.searchbytag

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.usecases.cow.FindCowByTagUseCase
import com.example.app_ui.common.core.base.launchUI
import com.example.app_ui.common.core.base.withIO
import com.example.app_ui.ext.createHandler
import com.example.app_ui.screens.cowcard.CowCardNextAction
import com.example.app_ui.screens.cowcard.CowCardScreen
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class SearchByTagPresenter : BasePresenter<SearchByTagView>() {

    private val findCowByTagUseCase: FindCowByTagUseCase by inject()

    private var currentType = 0

    fun onChangeSearchType(type: Int) {
        currentType = type
        viewState.changeType(type == 0)
    }

    fun searchByTag(tag: String) {
        if (currentType == 0 && tag.isNotBlank()) {
            launchUI(createHandler {
                viewState.showErrorToast(it.message!!)
                viewState.toggleLoading(false)
            }) {
                viewState.toggleLoading(true)
                val cow = withIO { findCowByTagUseCase(tag) }
                viewState.toggleLoading(false)
                router?.navigateTo(CowCardScreen(
                    cow = cow,
                    nextAction = CowCardNextAction.BACK,
                    nextScreen = null,
                ))
            }
        }
    }

    fun onBack() = router?.exit()
}