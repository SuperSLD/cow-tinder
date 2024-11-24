package com.example.app_ui.screens.best_partners

import com.arellomobile.mvp.InjectViewState
import com.example.app_domain.models.cow.Cow
import com.example.app_ui.R
import com.example.app_ui.screens.cowcard.CowCardNextAction
import com.example.app_ui.screens.cowcard.CowCardScreen
import com.example.app_ui.screens.paircowcard.PairCowCardScreen
import com.example.app_ui.screens.parameter_selection.ParameterSelectionScreen
import com.example.app_ui.screens.success.InstructionNextAction
import com.example.app_ui.screens.success.InstructionScreen
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class BestPartnersPresenter(
    private val params: BestPartnerScreen
): BasePresenter<BestPartnerView>() {

    fun onBack() = router?.exit()

    override fun attachView(view: BestPartnerView?) {
        super.attachView(view)
        viewState.showCowList(params.cowPairResultList.map { it.otherCow })
    }

    fun onCowClick(cow: Cow) {
        val cowResult = params.cowPairResultList.find { it.otherCow.id == cow.id }
        router?.navigateTo(
            PairCowCardScreen(
                cowPairResult = cowResult!!
            )
        )
    }
}