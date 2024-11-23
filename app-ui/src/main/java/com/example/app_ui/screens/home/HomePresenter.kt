package com.example.app_ui.screens.home

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.usecases.user.LoginUseCase
import com.example.app_ui.common.core.base.launchUI
import com.example.app_ui.common.core.base.withIO
import com.example.app_ui.ext.createHandler
import com.example.app_ui.screens.main.FlowMainScreen
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class HomePresenter : BasePresenter<HomeView>() {

    fun onOpenNewCowProcess() {

    }

    fun onOpenCowInfoProcess() {

    }

    fun onOpenCowSexProcess() {

    }

    fun onOpenCowInventoryProcess() {

    }

    fun onBack() = router?.exit()
}