package com.example.app_ui.screens.splash

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import com.example.app_ui.common.core.base.launchIO
import com.example.app_ui.common.core.base.withUI
import com.example.app_ui.ext.createEmptyHandler
import com.example.app_ui.screens.auth.login.LoginScreen
import kotlinx.coroutines.delay
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class SplashPresenter : BasePresenter<MvpView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        start()
    }

    private fun start() {
        launchIO(createEmptyHandler()) {
            delay(2000)
            withUI {
                router?.newRootScreen(LoginScreen())
            }
        }
    }

    fun onBack() = router?.exit()
}