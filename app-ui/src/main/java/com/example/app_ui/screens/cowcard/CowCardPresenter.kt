package com.example.app_ui.screens.cowcard

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.models.cow.Cow
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class CowCardPresenter(
    private val params: CowCardScreen,
) : BasePresenter<CowCardView>() {

    override fun attachView(view: CowCardView?) {
        super.attachView(view)
        showCow(params.cow)
    }

    private fun showCow(cow: Cow) {
        viewState.showCow(cow)
    }

    fun onButtonClick() {
        when(params.nextAction) {
            CowCardNextAction.NEXT -> {
                router?.navigateTo(params.nextScreen!!)
            }
            CowCardNextAction.BACK -> {
                router?.exit()
            }
            CowCardNextAction.ROOT -> {
                router?.newRootScreen(params.nextScreen!!)
            }
        }
    }

    fun onBack() = router?.exit()
}