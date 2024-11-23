package com.example.app_ui.screens.auth.login

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.usecases.user.LoginUseCase
import com.example.app_ui.common.core.base.launchUI
import com.example.app_ui.common.core.base.withIO
import com.example.app_ui.ext.createHandler
import com.example.app_ui.screens.main.FlowMainScreen
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class LoginPresenter : BasePresenter<LoginView>() {

    private val loginUseCase: LoginUseCase by inject()

    fun onLogin(login: String, password: String) {
        launchUI(createHandler {
            viewState.showErrorToast(it.message!!)
            viewState.toggleLoading(false)
        }) {
            viewState.toggleLoading(true)
            router?.navigateTo(FlowMainScreen())
            val authResponse = withIO { loginUseCase(login, password) }
            if (!authResponse.token.isNullOrEmpty()) {
                router?.navigateTo(FlowMainScreen())
            }
        }
    }

    fun onBack() = router?.exit()
}