package com.example.app_ui.screens.main.sections.detail

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.controllers.BottomVisibilityController
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class SectionDetailPresenter(
    private val params: SectionDetailScreen,
) : BasePresenter<SectionDetailView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        bottomVisibilityController.setVisible(false)
        viewState.showSection(params.section)
    }

    fun onBack() = router?.exit()
}