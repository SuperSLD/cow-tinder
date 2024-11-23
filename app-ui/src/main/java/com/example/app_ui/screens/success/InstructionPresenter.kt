package com.example.app_ui.screens.success

import com.arellomobile.mvp.InjectViewState
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class InstructionPresenter(
    private val params: InstructionScreen,
) : BasePresenter<InstructionView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setContent(
            subtitle = params.subtitleRes,
            buttonTitle = params.buttonRes,
            icon = params.iconRes,
        )
    }

    fun onConfirm() {
        when(params.nextAction) {
            InstructionNextAction.NEXT -> {
                router?.navigateTo(params.nextScreen!!)
            }
            InstructionNextAction.BACK -> {
                router?.exit()
            }
            InstructionNextAction.ROOT -> {
                router?.newRootScreen(params.nextScreen!!)
            }
        }
    }

    fun onBack() = router?.exit()
}